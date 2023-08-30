# Programming the IoT - Java Components
This is the source repository for the Java components related to my Programming the Internet of Things book and Connected Devices IoT course. These are shell wrappers ONLY and are not a solution set (which is a separate repository, not yet released). For convenience to the reader, some basic functionality has already been implemented (such as configuration logic, consts, interfaces, a simple certificate file load utility, and test cases).

The code in this repository is largely comprised of shell classes that are designed to be implemented by the reader and are NOT solutions. These shell classes and their relationships respresent a notional design that aligns with the requirements listed in [Programming the IoT Requirements](https://github.com/orgs/programming-the-iot/projects/1). These requirements encapsulate the programming exercises presented in my book [Programming the Internet of Things: An Introduction to Building Integrated, Device to Cloud IoT Solutions](https://learning.oreilly.com/library/view/programming-the-internet/9781492081401).

## Links, Exercises, Updates, Errata, and Clarifications

Please see the following links to access exercises, errata / clarifications, and the e-book:
 - [Programming the IoT Kanban Board](https://github.com/orgs/programming-the-iot/projects/1)
 - [Errata and Clarifications](https://labbenchstudios.com/programming-the-iot-book/programming-the-iot-1st-edition/)
 - [Programming the Internet of Things Book](https://learning.oreilly.com/library/view/programming-the-internet/9781492081401/)

## How to use this repository
If you're reading [Programming the Internet of Things: An Introduction to Building Integrated, Device to Cloud IoT Solutions](https://learning.oreilly.com/library/view/programming-the-internet/9781492081401), you'll see a tie-in with the exercises described in each chapter and this repository. Most of the code in the main src tree is NOT implemented by design. It's intended for you - as the reader of my book (and possibly a student in one of my IoT courses) - to implement by filling in the implementation details as you work through each exercise.

A solution set is available, although I haven't yet released it. Stay tuned for updates on this topic.

## This repository aligns to exercises in Programming the Internet of Things
These components are all written in Java 11 (or higher), and correlate to the exercises designed for the Gateway Device Application (GDA) specified in my book [Programming the Internet of Things: An Introduction to Building Integrated, Device to Cloud IoT Solutions](https://learning.oreilly.com/library/view/programming-the-internet/9781492081401).

## How to navigate the directory structure for this repository
This repository is comprised of the following top level paths:
- [config](https://github.com/programming-the-iot/java-components/tree/default/config): Contains basic configuration file(s).
- [src](https://github.com/programming-the-iot/java-components/tree/default/src): Contains the following source trees:
  - [src/main/java](https://github.com/programming-the-iot/java-components/tree/default/src/main/java): The main source tree for java-components. Keep in mind that most of these classes are shell representations ONLY and must be implemented as part of the exercises referenced above.
  - [src/test/java](https://github.com/programming-the-iot/java-components/tree/default/src/test/java): The test source tree for java-components. These are designed to perform very basic unit and integration testing of the implementation of the exercises referenced above. This tree is sectioned by part - part01, part02, part03, and part04 - which correspond to the structure of Programming the Internet of Things.

Here are some other files at the top level that are important to review:
- [pom.xml](https://github.com/programming-the-iot/java-components/blob/default/pom.xml): The Maven project configuration file, with relevant depedencies, etc.
- [README.md](https://github.com/programming-the-iot/java-components/blob/default/README.md): This README.me file.
- [LICENSE](https://github.com/programming-the-iot/java-components/blob/default/LICENSE): The repository's LICENSE file.

Lastly, here are some 'dot' ('.{filename}') files pertaining to dev environment setup that you may find useful (or not - if so, just delete them after cloning the repo):
- [.classpath](https://github.com/programming-the-iot/java-components/blob/default/.classpath): The Eclipse IDE CLASSPATH configuration file for your Java environment that may / may not be useful for your own cloned instance.
- [.gitignore](https://github.com/programming-the-iot/java-components/blob/default/.gitignore): The obligatory .gitignore that you should probably keep in place, with any additions that are relevant for your own cloned instance.
- [.project](https://github.com/programming-the-iot/java-components/blob/default/.project): The Eclipse IDE project configuration file that may / may not be useful for your own cloned instance. Note that using this file to help create your Eclipse IDE project will result in the project name 'piot-java-components' (which can be changed, of course).
- [.settings/org.eclipse.jdt.core.prefs](https://github.com/programming-the-iot/java-components/blob/default/.settings/org.eclipse.jdt.core.prefs): The Eclipse IDE settings file, which is only included to assist with setting up an Eclipse dev environment related to my IoT courses and book exercises, which may / may not be useful for your own cloned instance.

NOTE: The directory structure and all files are subject to change based on feedback I receive from readers of my book and students in my IoT class, as well as improvements I find to be helpful for overall repo betterment.

# Other things to know

## Pull requests
PR's are disabled while the codebase is being developed.

## Updates
Much of this repository, and in particular unit and integration tests, will continue to evolve, so please check back regularly for potential updates. Please note that API changes can - and likely will - occur at any time.

# REFERENCES
This repository has external dependencies on other open source projects. I'm grateful to the open source community and authors / maintainers of the following libraries:

Lab Module Library References (not all are required for each lab module):

- [aws-iot-device-sdk-java](https://github.com/aws/aws-iot-device-sdk-java)
  - Reference: AWS. AWS IoT Device SDK (Java). (2023) [Online]. Available: https://github.com/aws/aws-iot-device-sdk-java.
- [aws-iot-device-sdk-java-samples](https://github.com/aws/aws-iot-device-sdk-java)
  - Reference: AWS. AWS IoT Device SDK Samples (Java). (2023) [Online]. Available: https://github.com/aws/aws-iot-device-sdk-java.
- [azure-iot-device-client](https://github.com/Azure/azure-iot-sdk-java)
  - Reference: Microsoft. Azure IoT Device Client (Java). (2023) [Online]. Available: https://github.com/Azure/azure-iot-sdk-java.
- [californium-core](https://github.com/eclipse/californium)
  - Reference: Eclipse Foundation, Inc. Californium (Cf) - CoAP for Java. (2020) [Online]. Available. https://github.com/eclipse/californium.
- [californium/scandium-core](https://github.com/eclipse/californium/tree/master/scandium-core)
  - Reference: Eclipse Foundation, Inc. Scandium (Sc) - Security for Californium. (2021) [Online]. Available. https://github.com/eclipse/californium/tree/master/scandium-core.
- [commons-cli](https://commons.apache.org/proper/commons-cli/)
  - Reference: The Apache Software Foundation. Commons CLI. (2019) [Online]. Available. https://commons.apache.org/proper/commons-cli/.
- [commons-configuration2](commons.apache.org/proper/commons-configuration/)
  - Reference: The Apache Software Foundation. Commons Configuration 2. (2023) [Online]. Available: https://commons.apache.org/proper/commons-configuration/.
- [org.eclipse.paho.client.mqttv3](https://www.eclipse.org/paho/)
  - Reference: Eclipse Foundation, Inc. Eclipse Paho Java Client. (2020) [Online]. Available: https://github.com/eclipse/paho.mqtt.java.
- [org.eclipse.paho.mqttv5.client](https://www.eclipse.org/paho/)
  - Reference: Eclipse Foundation, Inc. Eclipse Paho Java Client. (2023) [Online]. Available: https://github.com/eclipse/paho.mqtt.java.
- [gson](https://github.com/google/gson)
  - Reference: Google. Gson. (2008) [Online]. Available: https://github.com/google/gson.
- [influxdb-client-java](https://github.com/influxdata/influxdb-client-java)
  - Reference: Influx Data, Inc. Influx DB. (2023) [Online]. Available: https://github.com/influxdata/influxdb-client-java.
- [jakarta.mail-api](https://jakartaee.github.io/mail-api/)
  - Reference: Eclipse Foundation, Inc. Jakarta Mail. (2023) [Online]. Available: https://github.com/jakartaee/mail-api.
- [jedis](https://github.com/redis/jedis)
  - Reference: J. Leibiusky. Jedis. (2020) [Online]. Available: https://github.com/redis/jedis.
- [junit](https://github.com/junit-team/junit4/)
  - Reference: JUnit. JUnit 4. (2020) [Online]. Available: https://junit.org/junit4/.

NOTE: This list will be updated as other libraries / dependencies are incorporated.

# FAQ
For typical questions (and answers) to the repositories of the Programming the IoT project, please see the [FAQ](https://github.com/programming-the-iot/book-exercise-tasks/blob/default/FAQ.md).

# IMPORTANT NOTES
This code base is under active development.

If  any  code  samples  or  other  technology  this  work  contains, describes, and / or is  subject  to  open  source licenses  or  the  intellectual  property  rights  of  others,  it  is  your  responsibility  to  ensure  that  your  use thereof complies with such licenses and/or rights.

# LICENSE
Please see [LICENSE](https://github.com/programming-the-iot/java-components/blob/default/LICENSE) if you plan to use this code.

Please refer to the referenced libraries for their respective licenses.
