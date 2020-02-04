## Contact Manager
 
 Contact Manager application using Play 1.2.4.
 
 ## Notes
Uses H2 internal memory at the moment. Add db configuration to acheive persistance beyond the application runtime.
SMTP settings have to be added for the emails to be sent. It's set as mock for now.
 
 ## Usage
     
 ##### SET UP THE APPLICATION:
     Set up play 1.2.4
     play dependencies
 
 
 ##### TO RUN THE APPLICATION:
     play run
 
 
 ##### USING THE APPLICATION:
    Signing up and Logging in:
        - The initial logging screen set the username and password when signing up.
        - Log in with the same password. Password cannot be changed.
        - Validation to check whether username is email id not added. Please enter an email id when signing up.
    Add a contact.
        - Add a contact with the email of the contact at the home page text box.
        - Will only get added if the user has signed up with the application.
    Set Date of Birth and notification time:
        - Can be set at the settings menu, under the drop down at the top right corner.
