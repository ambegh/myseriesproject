/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * HouseKeeping.java
 *
 * Created on 13 Απρ 2011, 7:57:38 μμ
 */
package tools.misc.housekeeping;

import database.DBConnection;
import database.SeriesRecord;
import java.awt.List;
import java.io.File;
import java.io.FilenameFilter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import myComponents.MyUsefulFunctions;
import myComponents.myGUI.MyDraggable;
import tools.MySeriesLogger;
import tools.Skin;
import tools.options.Options;
import tools.options.Paths;

/**
 *
 * @author lordovol
 */
public class HouseKeeping extends MyDraggable {

  private static final long serialVersionUID = 345636475467L;
  File[] torrents;
  File[] logs;
  File[] screenshots;
  private HashSet<String> usedScreenshots = new HashSet<String>();

  /** Creates new form HouseKeeping */
  public HouseKeeping() {
    MySeriesLogger.logger.log(Level.INFO, "Initializong components");
    initComponents();
    gettingTorrents();
    lb_torrents.setText("( " + torrents.length + " torrents)");
    gettingLogs();
    lb_log.setText("( " + logs.length + " old logs)");
    gettingUsedScreenshots();
    screenshots = findUnusedScreenshots();
    lb_screenshots.setText("( " + screenshots.length + " unused screenshots)");
    MySeriesLogger.logger.log(Level.FINE, "Components initialized");
    myseries.MySeries.glassPane.activate(null);
    setLocationRelativeTo(null);
    setVisible(true);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    outer_panel = new javax.swing.JPanel();
    inner_panel = new javax.swing.JPanel();
    cb_torrents = new javax.swing.JCheckBox();
    cb_logs = new javax.swing.JCheckBox();
    cb_screenhsots = new javax.swing.JCheckBox();
    progress = new javax.swing.JProgressBar();
    lb_torrents = new javax.swing.JLabel();
    lb_log = new javax.swing.JLabel();
    lb_screenshots = new javax.swing.JLabel();
    jLabel1 = new javax.swing.JLabel();
    bt_cancel = new myComponents.myGUI.buttons.MyButtonCancel();
    bt_ok = new myComponents.myGUI.buttons.MyButtonOk();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);

    outer_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    inner_panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    inner_panel.setOpaque(false);

    cb_torrents.setSelected(true);
    cb_torrents.setText("Delete downloaded torrents");

    cb_logs.setSelected(true);
    cb_logs.setText("Delete old log files");

    cb_screenhsots.setSelected(true);
    cb_screenhsots.setText("Delete unused screenshots");

    progress.setStringPainted(true);

    javax.swing.GroupLayout inner_panelLayout = new javax.swing.GroupLayout(inner_panel);
    inner_panel.setLayout(inner_panelLayout);
    inner_panelLayout.setHorizontalGroup(
      inner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(inner_panelLayout.createSequentialGroup()
        .addGroup(inner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(inner_panelLayout.createSequentialGroup()
            .addGap(14, 14, 14)
            .addGroup(inner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
              .addComponent(cb_screenhsots, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(cb_logs, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addComponent(cb_torrents, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(inner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(lb_screenshots, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
              .addComponent(lb_torrents, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
              .addComponent(lb_log, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)))
          .addGroup(inner_panelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(progress, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)))
        .addContainerGap())
    );
    inner_panelLayout.setVerticalGroup(
      inner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(inner_panelLayout.createSequentialGroup()
        .addGap(16, 16, 16)
        .addGroup(inner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(cb_torrents)
          .addComponent(lb_torrents, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(inner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(cb_logs)
          .addComponent(lb_log, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(inner_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(cb_screenhsots)
          .addComponent(lb_screenshots, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(35, 35, 35)
        .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    inner_panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_logs, cb_screenhsots, cb_torrents, lb_log, lb_screenshots, lb_torrents});

    jLabel1.setFont(jLabel1.getFont().deriveFont(jLabel1.getFont().getStyle() | java.awt.Font.BOLD, jLabel1.getFont().getSize()+2));
    jLabel1.setForeground(Skin.getTitleColor());
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Housekeeping");

    bt_cancel.setText("");
    bt_cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_cancelActionPerformed(evt);
      }
    });

    bt_ok.setText("");
    bt_ok.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_okActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout outer_panelLayout = new javax.swing.GroupLayout(outer_panel);
    outer_panel.setLayout(outer_panelLayout);
    outer_panelLayout.setHorizontalGroup(
      outer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(outer_panelLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(outer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(outer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outer_panelLayout.createSequentialGroup()
              .addComponent(inner_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, outer_panelLayout.createSequentialGroup()
              .addGap(31, 31, 31)
              .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
              .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(bt_ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
    );
    outer_panelLayout.setVerticalGroup(
      outer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(outer_panelLayout.createSequentialGroup()
        .addGroup(outer_panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(jLabel1)
          .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(inner_panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(outer_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(outer_panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
      MySeriesLogger.logger.log(Level.INFO, " Canceled by the user");
      myseries.MySeries.glassPane.deactivate();
      dispose();
}//GEN-LAST:event_bt_cancelActionPerformed

    private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
      MySeriesLogger.logger.log(Level.INFO, "Starting housekeeping");
      HouseKeeper h = new HouseKeeper(this);
      Thread t = new Thread(h);
      t.start();
}//GEN-LAST:event_bt_okActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  private myComponents.myGUI.buttons.MyButtonCancel bt_cancel;
  private myComponents.myGUI.buttons.MyButtonOk bt_ok;
  javax.swing.JCheckBox cb_logs;
  javax.swing.JCheckBox cb_screenhsots;
  javax.swing.JCheckBox cb_torrents;
  private javax.swing.JPanel inner_panel;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel lb_log;
  private javax.swing.JLabel lb_screenshots;
  private javax.swing.JLabel lb_torrents;
  private javax.swing.JPanel outer_panel;
  javax.swing.JProgressBar progress;
  // End of variables declaration//GEN-END:variables

  private File[] gettingTorrents() {
    MySeriesLogger.logger.log(Level.INFO, "Getting torrents in the torrent dir");
    File torrentDir = new File(Options._USER_DIR_ + Paths.TORRENTS_PATH);
    torrents = torrentDir.listFiles();
    int t = torrents.length;
    MySeriesLogger.logger.log(Level.INFO, "Found {0} torrents", t);
    return torrents;
  }

  private File[] gettingLogs() {
    MySeriesLogger.logger.log(Level.INFO, "Getting old log files");
    File dir = new File(Paths.LOGS_PATH);
    logs = dir.listFiles(new FilenameFilter() {

      @Override
      public boolean accept(File dir, String name) {
        if (name.matches("MySeriesLog_([1-9]\\.html$|[0-9]\\.html\\.\\d+)")) {
          return true;
        }
        return false;
      }
    });
    MySeriesLogger.logger.log(Level.INFO, "Found {0} old log files", logs.length);
    return logs;
  }

  private void gettingScreenshotsForDb(String db) {
    try {
      MySeriesLogger.logger.log(Level.INFO, "Getting unused screenshots");
      ResultSet r = SeriesRecord.query(new DBConnection(db).stmt, "SELECT screenshot FROM series");
      while (r.next()) {
        String screenshot = r.getString("screenshot");
        if (!screenshot.equals("")) {
          usedScreenshots.add(screenshot);
        }
      }
      File dir = new File(Options._USER_DIR_ + Paths.SCREENSHOTS_PATH);
    } catch (SQLException ex) {
      MySeriesLogger.logger.log(Level.SEVERE, "Could not get screenshots", ex);

    }
  }

  private void gettingUsedScreenshots() {
    String curDb = Options.toString(Options.DB_NAME);
    File dbdir = new File(Paths.DATABASES_PATH);
    File[] dbs = dbdir.listFiles(new FilenameFilter() {

      @Override
      public boolean accept(File dir, String name) {
        return name.endsWith(".db");
      }
    });

    for (int i = 0; i < dbs.length; i++) {
      String db = dbs[i].getName();
      gettingScreenshotsForDb(db);
    }
    new DBConnection(curDb);
  }

  private File[] findUnusedScreenshots() {
    ArrayList<File> f = new ArrayList<File>();
    File[] scs = new File(Paths.SCREENSHOTS_PATH).listFiles();
    for (int i = 0; i < scs.length; i++) {
      String sc = scs[i].getName();
      if(!MyUsefulFunctions.isInList(sc,usedScreenshots)){
        f.add(new File(Paths.SCREENSHOTS_PATH + sc));
      }
    }
    return f.toArray(new File[f.size()]);
  }
}
