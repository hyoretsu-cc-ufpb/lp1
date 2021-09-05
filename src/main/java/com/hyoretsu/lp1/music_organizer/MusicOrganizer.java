package com.hyoretsu.lp1.music_organizer;

import java.util.ArrayList;

public class MusicOrganizer {
 /** An ArrayList for storing the file names of music files. */
 private ArrayList<String> files;
 /** A player for the music files. */
 private MusicPlayer player;

 /** Create a MusicOrganizer */
 public MusicOrganizer() {
  files = new ArrayList<>();
  player = new MusicPlayer();
 }

 /**
  * Add a file to the collection.
  *
  * @param filename The file to be added.
  */
 public void addFile(String filename) {
  files.add(filename);
 }

 // Exercise 4.14
 public void checkIndex(Integer index) {
  Integer size = files.size();

  if (index < 0 || index >= size) {
   System.out.println("The valid range for currently stored musics is: 0" + ((size == 1) ? "" : ("~" + (size - 1))));
  }
 }

 /**
  * Return the number of files in the collection.
  *
  * @return The number of files in the collection.
  */
 public int getNumberOfFiles() {
  return files.size();
 }

 // Exercise 4.18
 public void listAllFiles() {
  // Exercise 4.24
  for (Integer i = 0; i < files.size(); i++) {
   System.out.println(i + ": " + files.get(i));
  }
 }

 /**
  * List a file from the collection.
  *
  * @param index The index of the file to be listed.
  */
 public void listFile(int index) {
  if (validIndex(index)) {
   String filename = files.get(index);
   System.out.println(filename);
  }
 }

 /**
  * Play a file in the collection. Only return once playing has finished.
  *
  * @param index The index of the file to be played.
  */
 public void playAndWait(int index) {
  if (validIndex(index)) {
   String filename = files.get(index);
   player.playSample(filename);
  }
 }

 /**
  * Remove a file from the collection.
  *
  * @param index The index of the file to be removed.
  */
 public void removeFile(int index) {
  if (validIndex(index)) {
   files.remove(index);
  }
 }

 /**
  * Start playing a file in the collection. Use stopPlaying() to stop it playing.
  *
  * @param index The index of the file to be played.
  */
 public void startPlaying(int index) {
  if (validIndex(index)) {
   String filename = files.get(index);
   player.startPlaying(filename);
  }
 }

 /** Stop the player. */
 public void stopPlaying() {
  player.stop();
 }

 // Exercise 4.15
 public Boolean validIndex(Integer index) {
  Integer size = files.size();

  if (index < 0 || index >= size) {
   return false;
  }

  return true;
 }
}
