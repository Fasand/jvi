# VJI (Vim Java Interface)
This project is hoping to serve as an interface (plugin) for VIM to build and run Java files

# Setup
- Configuration file (json, conf, something with native support from Java or Bash)
	- Add to each workspace folder
	- Can be created by the app itself
	- Should be compatible with Eclipse, maybe even others later
		- Or you can just import the whole folder as a new project
	- Contain:
		- src folder location
		- bin folder location
		- javac custom parameters
		- java custom parameters

# Workflow
- Setup the workspace
- Write your code
- Build/Build&Run 
	- In VIM: :jvi run
	- Outside: jvi run JavaFile.java
- Test
	- In VIM: :jvi test
	- Outside: jvi test JavaFileTest.java
- Repeat

# Features
- Useful Java snippets (class, main(), loops, conditionals, ...)

