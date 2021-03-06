package com.hyoretsu.lp1.mail_system;

public class MailClient {
 /** The server used for sending and receiving. */
 private MailServer server;
 /** The user running this client. */
 private String user;

 /** Create a mail client run by user and attached to the given server. */
 public MailClient(MailServer server, String user) {
  this.server = server;
  this.user = user;
 }

 /** Return the next mail item (if any) for this user. */
 public MailItem getNextMailItem() {
  return server.getNextMailItem(user);
 }

 /** Print the next mail item (if any) for this user to the text terminal. */
 public void printNextMailItem() {
  MailItem item = server.getNextMailItem(user);
  if (item == null) {
   System.out.println("No new mail.");
  } else {
   item.print();
  }
 }

 /**
  * Send the given message to the given recipient via the attached mail server.
  *
  * @param to      The intended recipient.
  * @param subject The subject of the message.
  * @param message The text of the message to be sent.
  */
 public void sendMailItem(String to, String subject, String message) {
  MailItem item = new MailItem(user, to, subject, message);
  server.post(item);
 }
}
