import cherrypy
import json
from firebase import firebase
from firebase import jsonutil
import time
import datetime

firebase = firebase.FirebaseApplication('https://smarkt-bac7b.firebaseio.com/', None)

def setup():
	class Generator:

		def index (self, *uri, ** params):
			return '''
			WELCOME TO SMARKT:<br />
			<form id='login' action='login' method='post' accept-charset='UTF-8'>
			<fieldset >
			<legend>Login</legend>
			<label for='username' >UserName*:</label>
			<input type='text' name="username" id="username" maxlength="50" />
			<label for='password' >Password*:</label>
			<input type='password' name='password' id='password' maxlength="50" />
			<input type='submit'  value='Submit' />
			</form>
			</fieldset>

			<form id='register' action='register' method='post'
			accept-charset='UTF-8'>
			<fieldset >
			<legend>Register</legend>
			<label for='name' >Your Full Name*: </label>
			<input type='text' name='name' id='name' maxlength="50" />
			<label for='email' >Email Address*:</label>
			<input type='text' name='email' id='email' maxlength="50" />
			<label for='username' >UserName*:</label>
			<input type='text' name='username' id='username' maxlength="50" />
			<label for='password' >Password*:</label>
			<input type='password' name='password' id='password' maxlength="50" />
			<input type='submit' value='Submit' />
			</fieldset>
			</form>
				
			'''
		index.exposed = True
				
		def login (self,username,password):
			LoginLoop = True
			while LoginLoop == True:
				print("Logando coglione")
				attempt = '/users/' + username
				auth = firebase.get(attempt, None)
				if auth['password'] == password:
					print("Logged in!")
					currentUser = username
					LoggedIn = True
					LoginLoop = False
				else:
					print("INCORRECT PASSWORD!")
			return LoggedIn
		login.exposed = True

		def register (self, name,email,username,password):
			createUser = firebase.patch('/users', { username : { "username" : username , "password" : password, "email": email, "name":name}})
			currentUser = username
			print("Username not taken, creating user!")
			return ("Welcome, @" + currentUser)
		register.exposed = True
	cherrypy.tree.mount (Generator(),	'/')
		

	
if __name__	== '__main__':
	setup()
	if LoggedIn != True:
		quit()
	#cherrypy.quickstart(Generator(), '/')
	cherrypy.engine.start()
	cherrypy.engine.block()		