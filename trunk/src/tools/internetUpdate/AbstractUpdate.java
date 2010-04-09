/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.internetUpdate;

import database.SeriesRecord;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import myComponents.MyMessages;
import myComponents.MyUsefulFunctions;
import myseries.*;
import tools.options.Options;

/**
 *
 * @author ssoldatos
 */
public abstract class AbstractUpdate {

  /**
   * The series to update
   */
  protected Vector<SeriesRecord> serVector = new Vector<SeriesRecord>();
 /**
  * The list of series to update
  */
  protected ArrayList<AbstractSeriesToUpdate> list = new ArrayList<AbstractSeriesToUpdate>();
  protected InternetUpdate iu = null;
  protected String currentMessages = "";
  protected int totalLinesParsed = 0;
  protected long start;
  protected long end;
  protected boolean isConected = false;
  protected SeriesRecord series;

  public void run() {
      start = System.currentTimeMillis();
      MySeries.logger.log(Level.INFO, "Updating...");
      update();
      if (!isConected) {
        MySeries.glassPane.deactivate();
        iu.dispose();
      }
    }

  protected String calcExecTime() {
    String execTime = "";
    int hours, mins, secs, mill;
    long t, a;
    end = System.currentTimeMillis();
    a = (end - start);
    t = (end - start) / 1000;
    mill = (int) a % 1000;
    secs = (int) t % 60;
    mins = (int) t / 60;
    hours = (int) t / 3600;

    execTime = MyUsefulFunctions.padLeft("" + mins, 2, "0") + ":"
        + MyUsefulFunctions.padLeft("" + secs, 2, "0") + ","
        + MyUsefulFunctions.padLeft("" + mill, 3, "0");
    return execTime;
  }

  protected void append(String str) {
    try {
      currentMessages += str + "<br />";
      iu.editor_messages.setText(currentMessages);
      iu.editor_messages.setCaretPosition(iu.editor_messages.getDocument().getLength() - 1);
    } catch (IllegalArgumentException ex) {
      myseries.MySeries.logger.log(Level.WARNING, "wrong caret position", ex);
    } finally {
    }
  }


  protected void update() {
    try {
      if (iu.getCurrentSeries() == null) {
        serVector = SeriesRecord.getSeriesBySql("SELECT * FROM series WHERE internetUpdate = 1");
      } else {
        serVector.add(iu.getCurrentSeries());
      }
      iu.progress_bar.setIndeterminate(true);
      iu.progress_bar.setString("Getting data from " +
              (Options.toString(Options.INTERNET_UPDATE_DB).equals(InternetUpdate.EP_GUIDES_NAME) ?
                "http://www.epguides.com" : "http://www.tvrage.com")
              );
      append("<span style='font-weight:bold;font-size:12px'>Step 1 : Getting data</span>");
      for (int i = 0; i < serVector.size(); i++) {
        series = serVector.get(i);
        iu.label_update_series.setText("Getting data for \"" + series.getFullTitle() + "\"");
        if (!read(series)) {
          return;
        }
        iu.label_update_series.setText("");
      }
      if (list.size() > 0) {
        updateEpisodes();
      } else {
        MySeries.logger.log(Level.WARNING, "Nothing to update");
        MyMessages.error("No Update!!!", "Nothing to update");
        MySeries.glassPane.deactivate();
        iu.dispose();
      }

    } catch (SQLException ex) {
      MySeries.logger.log(Level.WARNING, "Could not get the series from the database", ex.getMessage());
      MyMessages.error("SQL Error!!!", "Could not get the series from the database");
    }
  }

  /**
   * Reads from internet the episodes data of series and adds the data to the @list ArrayList
   * @param series
   * @return true if episodes data is read
   */
  protected abstract boolean read(SeriesRecord series);

  protected abstract void updateEpisodes() throws SQLException;

}