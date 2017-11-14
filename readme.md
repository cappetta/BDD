This is an opensource java framework consisting of cucumber, selenium, and expandable utility classes which create a holistic testing suite from feature definition to reporting of results.
 
 Input(s):
    The input design allows shared data to be defined as an object w/ variable declarations being in set in runtime using excel sheets/tab/column lookups.
    This can transformed into yaml, json, csv, type input as well.
  
    Note Only .XLS files can be used, .xslx are currently defective.  The necessary files are included as templates but the Primary Key Configurations are:
        - objectModel
            - define the location, definition of page object/element model on the "Page Object Model" tab
        - environment
            - maps the translation of the element to the user input'd information to the objects looked up in the object model
        - suite
            - has 3 tabs defined: 
                - Setup: defines Test name, Device, Browser, screenshots
                - Driver: defines the selenium driver to use
                - Testing: the urls to test
        
        
    