# flightgear_mobileapp
tichnut mitkadem 2 even derech 3

**Features Implemented:**
* Textboxes for user to input text
  * Input IP Adress
  * Input Port 
* Button
  * Connect button for user to connect to FlightGear after entering IP and port
* Joystick 
  * Joystick knob for user to change direction of plane using the aileron and elevator data 
* Seekbars
  * Throttle for user to control the height of the plane 
  * Rudder for user to control the angle of the plane 
  
  **Project Structure:**

 The application is built using the MVVM structure 
 * View
   *  activity_main.xml is responsible for the visual presentation of the application 
   *  MainActivity.kt, the code behind of the xml
   * Joystick.kt handles the canvas drawings and touch events of the joystick
 * ViewModel
   *  AppViewModel.kt is responsible for passing data from the view to the model  
 * Model
   *  Model.kt is responsible for connection to FlightGear and passing the data received from the view model 
   
   **Necessary Installations:**
* AndroidStudio 
* FlightGear

**Instruction to Run Application:**
* Download and install the FlightGear application at https://flightgear.org/
* Upon opening the application, go to settings -> additional settings and write:
--telnet=socket,in,10,127.0.0.1,6400,tcp
* To use the flight simulator, press "Fly" in the FlightGear application 
* Double click the "v" key to see the airplane from the outside 
* Press the name of the airplane, "Cessna C172P", and select the first option- autostart
* Run the application and enter an IP address and a port number  
* Press the connect button
* Move the throttle up to the highest position for takeoff 
* Control the airplane using the throttle, rudder, and joystick 

**Additional Links:**
* UML layout https://github.com/rkoolyk/flightgear_mobileapp/blob/master/UML_ED3.JPG
* Video demo of app https://youtu.be/_J0iVvzUNxQ
