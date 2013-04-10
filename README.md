#MONSTER MOVIE#

Monster Movie is an interactive, audio-reactive application built by [Tony Lim](https://github.com/tonylim) and [Mehan Jayasuriya](http://mehanjayasuriya.com/) and used for the live performance GOEMUL, which took place at the IAC Building in NYC on March 1, 2013. [Click here to watch a video of the performance](http://goemul.mehanjayasuriya.com/).

This application uses Processing/Java and MAX/MSP to sync the movement of animated characters to live music. Built as part of [Daniel Shiffman](http://www.shiffman.net/)'s 2012 Big Screens class at [NYU ITP](http://itp.nyu.edu/itp/).

The codebase for Monster Movie is built on top of Shiffman's [Most Pixels Ever](https://github.com/shiffman/Most-Pixels-Ever) framework. For information on how the MPE sections of this code work, see the excellent [MPE documentation here](https://github.com/shiffman/Most-Pixels-Ever/wiki).

A few notes on how this all works:

* This application was designed to be run at a resolution of 11520 x 1080, on a series of screens powered by three seperate machines. It can also be scaled and run locally on one machine, using the "local" and "scale" parameters. To run the application (either locally or on a remote server), you'll need to first run the [MPE Server application](https://github.com/shiffman/Most-Pixels-Ever/wiki/Processing-Tutorial).
* All of the animations were produced using the open-source animation software [Animata](http://animata.kibu.hu/).
* All of the animation files are saved as .nmt files, which are saved in the "data" folder, alongside their associated source images.
* We used the Processing 1.5.1 core, since that is the latest version of Processing that the Animata library for Processing is compatible with.
* We used a MAX patch to simultaneously route commands from two MIDI controllers to Ableton Live and our application, using OSC messages. In theory, the animations in our application could be synced with virtually any live or pre-recorded music by rerouting the OSC messages in the MAX patch.
* To see how we're receiving the OSC messages and then routing them to the machines controlling the various screens, see src>mpe>controller>Messenger.java.
* The bulk of our code is in src>mpe>examples>Drawer.java. This is where we parse the OSC messages recieved and draw elements on the screen.

More documentation, etc. to come!




