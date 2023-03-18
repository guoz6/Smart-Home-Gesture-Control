### Smart Home Gesture Control
This project consists two parts. The first part is an Android App that can help smart home users to learn and practice gestures to control smart home behaviors such as turn on lights. The second part uses machine learning to train the program to recognize gestures.
## Part 1: Smart Home Gesture Control App
This part of project creates an Android App. In the App users can choose the name of a gesture from a drop down list. After choosing, the screen will play showcase of the gesture for users to learn and users can replay the video as many times as they want. After seeing the video, users can choose to record the gestures and upload the recorded video to firebase.
## Part 2: Gesture Training and Recognition
This is a project that performs gesture recognition using a pre-trained Convolutional Neural Network (CNN) model. The project takes a video file containing a gesture as input and outputs the recognized gesture along with its label.
## Prerequisites
To run this project, you will need the following software:
Android Studio
Java
Python
OpenCV
NumPy
Pandas
TensorFlow
scikit-learn
## Usage
Clone this repository.
Install necessary packages.
For part two : create a directory named traindata and place your training data inside it. Each video file should be named in the following format: <output_label>_<gesture_name>_<PRACTICE>_<unique_id>_<USER_LAST_NAME>.mp4. For example, a video file of a gesture with output label 1, gesture name "FanOn", unique id 11 and user last name "GUO" should be named 1_FanOn_PRACTICE_11_GUO.mp4.
Run python main.py to extract features from the training data and create a csv file with output label for testing data.
Create a directory named test and place your test data inside it.

