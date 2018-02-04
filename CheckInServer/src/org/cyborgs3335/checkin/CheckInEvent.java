package org.cyborgs3335.checkin;

import java.io.Serializable;

/**
 * Event container, with check-in status (check-in/checkout) and time stamp.
 *
 * @author brian
 *
 */
public class CheckInEvent implements Serializable {

  private static final long serialVersionUID = 8447815623071049866L;
  //private static final long serialVersionUID = 8447815623071049867L;

  public enum Status { CheckedIn, CheckedOut }

  public static final CheckInActivity DEFAULT_ACTIVITY = new CheckInActivity("DEFAULT", 0, Long.MAX_VALUE);

  private final CheckInActivity activity;
  private final Status status;
  private final long timeStamp;

  public CheckInEvent(CheckInActivity activity, Status status, long timeStamp) {
    this.activity = activity;
    this.status = status;
    this.timeStamp = timeStamp;
  }

  public CheckInActivity getActivity() {
    return activity;
  }

  public Status getStatus() {
    return status;
  }

  public long getTimeStamp() {
    return timeStamp;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof CheckInEvent)) {
      return false;
    }
    CheckInEvent event = (CheckInEvent) obj;
    if ((activity == null && event.activity != null)
        || (activity != null && event.activity == null)) {
      return false;
    }
    if (!((activity == null && event.activity == null)
        || (activity.equals(event.activity)))) {
      return false;
    }
    return status.equals(event.status)
        && timeStamp == event.timeStamp;
  }

  @Override
  public int hashCode() {
    long hashLong = (long) activity.hashCode() + (long) status.hashCode()
        + (long) Long.hashCode(timeStamp);
    return (int) hashLong;
  }
}
