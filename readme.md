# General
## Overview
The Sabre API Code Samples for Android project has been created to give developers creating systems consuming Sabre WebServices some basic examples, code snippets, best practices or even small libraries they could use while developing their code. It shows how to chain simple calls into more complex business cases, where subsequent calls use data returned from the previous ones.

## Building and configuring the application
The application was written in the Android Studio and has been tested on the Nexus 5 emulator. It also contains Gradle scripts, so it can be built independently.

The configuration can be obtained in two ways:

- Properties file – this is not the safe way to keep the Sabre Webservices credentials. Using reverse engineering, one can easily get both encryption key and algorithm. This is included only for testing or experimenting (e. g. hackathons, etc.). Your credentials available in the Sabre Dev Studio are given in such a format: `V1:userId:group:domain`, so they should be put into separate properties in the *SACSConfig.properties* file, which is located in *SabreAPICodeSamples\app\src\main\res\raw* folder.
- Configuration service – this is a safer way. Configuration can be obtained using an authenticated webservice (example included). The use case could do like this: user downloads and installs the mobile application from the Play Store -> Registers in the Client’s service, which holds Sabre’s credentials -> authenticates in the Client’s service before using Sabre’s webservices -> Client’s service sends Sabre’s credentials to the mobile application, so it can use the Sabre webservices.
The url for this service should be configured in the global project’s gradle.properties file in the *authUrl* property. Please note, that when running in the emulator, it should not be set to the *localhost* as it directs to the emulator.

## Running the application
The application can be built and run in the Android Studio using the emulator provided in the SDK or the artifacts can be installed on the Android device.

## Quickstart "How to"
To follow, how the example application works, you should first look into app’s module WorkflowRunnerActivity class. That's the place where the usage of webservices is being triggered. The runWorkflow() method initializes a Workflow with LeadPriceCalendar as its first activity to run. The LeadPriceCalendar constructor takes three parameters, which are the basic and required information taken from the UI form. It also constructs a GenericRestGetCall with request and response beans as generic parameters and creates the next activity that is to be run in this workflow.

```java
private InstaFlightActivity next = new InstaFlightActivity();

private GenericRestGetCall<LeadPriceCalendarRequest, LeadPriceCalendarResponse> call = new GenericRestGetCall<>();
```

The workflow runs until the activity returns *null* as the next activity to be run or there is a fault.

# Modules
## Configuration
Module to provide the configuration for the main app. It connects to the config service using the *authUrl* configured in the *gradle.properties* file and provides methods to obtain the Sabre’s REST webservices credentials.

The configuration may also be read from the *SACSConfig.properties* file, that is placed in the app/src/main/res/raw folder. The code to read it is commented out in the *WorkflowRunnerActivity*’s *onCreate()* method.
## Workflow
This module implements two design patterns – Workflow and Visitor. The former is used in the soap module for batching single calls to stateful flows which can be used to implement certain use cases. The state is being shared between activities using the SharedContext class instance. The latter is being used for error handling.

- SharedContext – contains a map of results indexed with a name of the call, indicates whether there was a fault during the workflow execution and also defines how many times should the workflow be rerun in case of a failure; implements the Visitable interface, so it can be visited by the error handling visitor.
- Workflow – class used for running use cases.
- Visitor, Visitable – interfaces of the Visitor pattern used in error handling.

## Domain
Classes copied from the Sabre API Code Samples for Java project. The domain model used for REST calls is copied from the Sabre API Code Samples for Java project. Some annotations like *@Generated* were removed, as they are not supported by the Android’s Jackson library.
## Rest
A module responsible for executing calls to the Sabre REST webservices. It also utilizes the Workflow module and reads settings from the Configuration module.

The domain model used for REST calls is copied from the Sabre API Code Samples for Java project. Some annotations like *@Generated* were removed, as they are not supported by the Android’s Jackson library.

The authentication takes place when any unauthenticated call attempts to take place. The TokenHolder class responsible for providing the authentication string checks, whether the token has been created and is not outdated. In any of those two cases, it runs the AuthenticationCall's doCall method, which reads credentials using Configuration module, encodes it in the way described on Sabre Developer Studio and (re)sets the token in the TokenHolder class.

In order to create a workflow, one should write classes implementing Activity interface, in which, depending whether it is POST or GET call, the GenericRestPostCall or GenericRestGetCall should be autowired with request class as a generic indicator.

In case of POST call, the URL should be set and a request object. One runs the call using the doCall() method with a response class as the argument.

In case of GET call, the URL should be set and a request object as well, but the URL should be just the base one for the service. The query part is being appended automatically based on the request object set. One can run the call in just the same way as in the POST case.

# Support

- [Stack Overflow](http://stackoverflow.com/questions/tagged/sabre "Stack Overflow")
- Need to report an issue/improvement? Use the built-in [issues] (https://github.com/SabreDevStudio/SACS-Android/issues) section
- [Sabre Dev Studio](https://developer.sabre.com/)

# Disclaimer of Warranty and Limitation of Liability
This software and any compiled programs created using this software are furnished “as is” without warranty of any kind, including but not limited to the implied warranties of merchantability and fitness for a particular purpose. No oral or written information or advice given by Sabre, its agents or employees shall create a warranty or in any way increase the scope of this warranty, and you may not rely on any such information or advice. Sabre does not warrant, guarantee, or make any representations regarding the use, or the results of the use, of this software, compiled programs created using this software, or written materials in terms of correctness, accuracy, reliability, currentness, or otherwise. The entire risk as to the results and performance of this software and any compiled applications created using this software is assumed by you. Neither Sabre nor anyone else who has been involved in the creation, production or delivery of this software shall be liable for any direct, indirect, consequential, or incidental damages (including damages for loss of business profits, business interruption, loss of business information, and the like) arising out of the use of or inability to use such product even if Sabre has been advised of the possibility of such damages.
