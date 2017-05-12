import cherrypy

class Generator(object):

	def hello (self, *uri, ** params):
		return '''
		WELCOME TO SMARKT:<br />
		<form id='login' action='login' method='post' accept-charset='UTF-8'>
		<fieldset >
		<legend>Login</legend>
		<input type='hidden' name='submitted' id='submitted' value='1'/>
		<label for='username' >UserName*:</label>
		<input type='text' name='username' id='username'  maxlength="50" />
		<label for='password' >Password*:</label>
		<input type='password' name='password' id='password' maxlength="50" />
		<input type='submit' name='Submit' value='Submit' />
		</fieldset>

		<form id='register' action='register' method='post'
		accept-charset='UTF-8'>
		<fieldset >
		<legend>Register</legend>
		<input type='hidden' name='submitted' id='submitted' value='1'/>
		<label for='name' >Your Full Name*: </label>
		<input type='text' name='name' id='name' maxlength="50" />
		<label for='email' >Email Address*:</label>
		<input type='text' name='email' id='email' maxlength="50" />
		<label for='username' >UserName*:</label>
		<input type='text' name='username' id='username' maxlength="50" />
		<label for='password' >Password*:</label>
		<input type='password' name='password' id='password' maxlength="50" />
		<input type='submit' name='Submit' value='Submit' />
		</fieldset>
		</form>
				
        '''
		
	hello.exposed = True
				
	def reply (self, *uri, ** params):
		return open('./hello/page.html','r').read()
		
	reply.exposed = True

if __name__	== '__main__':
	#cherrypy.quickstart(Generator(), '/')
	cherrypy.tree.mount (Generator(),	'/')
	cherrypy.engine.start()
	cherrypy.engine.block()