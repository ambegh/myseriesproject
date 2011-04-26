/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminEpisodes.java
 *
 * Created on 7 Νοε 2008, 5:37:48 μμ
 */
package myseries.episodes;

import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.RequiredValidator;
import database.DBConnection;
import database.DBHelper;
import java.io.IOException;
import java.text.ParseException;
import myseries.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import database.EpisodesRecord;
import database.SeriesRecord;
import help.HelpWindow;
import java.awt.Color;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import myComponents.MyMessages;
import myComponents.myGUI.MyDraggable;
import tools.Skin;
import tools.languages.LangsList;
import tools.languages.Language;
import tools.options.Options;
import tools.MySeriesLogger;

/**
 * The admin episodes panel
 * @author lordovol
 */
public class AdminEpisodes extends MyDraggable {

  public static final long serialVersionUID = 243564578251L;
  /**
   * The main form of MySeries
   */
  private MySeries m;
  /**
   * The series record of the episode to admin
   */
  private SeriesRecord seriesRecord;
  /**
   * The episode to edmin record
   */
  private EpisodesRecord episodeRecord;
  /**
   * The episodes number
   */
  private int episodeNo;

  /**
   * Administrate an episodes record
   * @param m Myseries main form
   * @param currentSerial The current series of the episode to admin
   * @param currentEpisode The episode to admin
   * @throws java.sql.SQLException
   * @throws java.io.IOException
   */
  public AdminEpisodes(MySeries m, SeriesRecord currentSerial, EpisodesRecord currentEpisode) throws SQLException, IOException {
    this.m = m;
    this.seriesRecord = currentSerial;
    this.episodeRecord = currentEpisode;
    MySeriesLogger.logger.log(Level.INFO, "Initializing components");
    initComponents();
    MySeriesLogger.logger.log(Level.FINE, "Components initialized");
    combobox_subtitles.setModel(new DefaultComboBoxModel(new Language[]{
          LangsList.NONE,
          myseries.MySeries.languages.getPrimary(),
          myseries.MySeries.languages.getSecondary(),
          LangsList.MULTIPLE
        }));
    setLocationRelativeTo(m);
    label_title.setText("Add new Episode");
    getLatestEpisode();
    spinner_episode.setValue(episodeNo);
    setVisible(true);
  }

  /**
   * Gets the latest episode of the series and sets the spinner to the next number
   * @throws java.sql.SQLException
   * @throws java.io.IOException
   */
  private void getLatestEpisode() throws SQLException, IOException {
    MySeriesLogger.logger.log(Level.INFO, "Get the latest episode");
    Vector<EpisodesRecord> episodes = DBHelper.getEpisodesBySql(
        "select * from episodes where series_ID = "
        + seriesRecord.getSeries_ID() + " order by CAST(episode AS INT) desc limit 1");
    if (episodes.size() > 0) {
      episodeNo = episodes.get(0).getEpisode() + 1;
      MySeriesLogger.logger.log(Level.FINE, "Episode found {0}", episodes.get(0).getEpisode());
    } else {
      episodeNo = 1;
      MySeriesLogger.logger.log(Level.INFO, "No episode found.Setting next episode to 1");
    }
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanel1 = new javax.swing.JPanel();
    label_title = new javax.swing.JLabel();
    jPanel2 = new javax.swing.JPanel();
    dateChooser = new com.toedter.calendar.JDateChooser();
    checkbox_seen = new javax.swing.JCheckBox();
    label_EpisodeTitle = new javax.swing.JLabel();
    label_subtitles = new javax.swing.JLabel();
    label_EpisodeNumber = new javax.swing.JLabel();
    combobox_subtitles = new javax.swing.JComboBox();
    textfield_title = new com.googlecode.svalidators.formcomponents.STextField(new RequiredValidator());
    checkbox_downloaded = new javax.swing.JCheckBox();
    label_Date = new javax.swing.JLabel();
    spinner_episode = new javax.swing.JSpinner();
    bt_cancel = new myComponents.myGUI.buttons.MyButtonCancel();
    bt_ok = new myComponents.myGUI.buttons.MyButtonOk();
    bt_help = new myComponents.myGUI.buttons.MyButtonHelp();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setUndecorated(true);

    jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
    jPanel1.setOpaque(false);

    label_title.setFont(label_title.getFont().deriveFont(label_title.getFont().getStyle() | java.awt.Font.BOLD, label_title.getFont().getSize()+2));
    label_title.setForeground(Skin.getTitleColor());
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

    jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    dateChooser.setDateFormatString(Options.toString(Options.DATE_FORMAT));
    dateChooser.setOpaque(false);

    checkbox_seen.setText("Seen");
    checkbox_seen.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
    checkbox_seen.setOpaque(false);

    label_EpisodeTitle.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_EpisodeTitle.setText("Title:");

    label_subtitles.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_subtitles.setText("Subtitles:");
    label_subtitles.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

    label_EpisodeNumber.setText("Episode:");

    textfield_title.setName("Title"); // NOI18N
    textfield_title.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        textfield_titleKeyReleased(evt);
      }
    });

    checkbox_downloaded.setText("Downloaded");
    checkbox_downloaded.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
    checkbox_downloaded.setOpaque(false);

    label_Date.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_Date.setText("Date:");

    spinner_episode.setModel(new javax.swing.SpinnerNumberModel(1, 0, 99, 1));
    spinner_episode.setEditor(new javax.swing.JSpinner.NumberEditor(spinner_episode, ""));
    spinner_episode.setValue(episodeNo);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
            .addGap(37, 37, 37)
            .addComponent(label_EpisodeNumber, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addComponent(label_EpisodeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
          .addComponent(label_subtitles, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
          .addComponent(label_Date, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(combobox_subtitles, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(dateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
              .addComponent(spinner_episode, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(checkbox_seen, javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(checkbox_downloaded, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGap(63, 63, 63))
          .addGroup(jPanel2Layout.createSequentialGroup()
            .addComponent(textfield_title, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())))
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_EpisodeNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
          .addComponent(spinner_episode, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(2, 2, 2)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_EpisodeTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
          .addComponent(textfield_title, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_Date, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
          .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(checkbox_downloaded, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
          .addComponent(label_subtitles, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
          .addComponent(combobox_subtitles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(checkbox_seen, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
        .addContainerGap())
    );

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

    bt_help.setText("");
    bt_help.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        bt_helpActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(55, 55, 55)
            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 255, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addComponent(bt_ok, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(10, 10, 10))))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(bt_help, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(label_title, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(bt_ok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Adds the episode to the Database
   * @throws java.io.IOException
   */
  private void addTheEpisode() throws IOException, ParseException {

    if (episodeRecord == null) {
      episodeRecord = new EpisodesRecord();
      MySeriesLogger.logger.log(Level.INFO, "Adding new episode");
    } else {
      MySeriesLogger.logger.log(Level.INFO, "Updating the episode {0}", episodeRecord.getTitle());
    }
    episodeRecord.setSeries_ID(seriesRecord.getSeries_ID());
    episodeRecord.setTitle(textfield_title.getText().trim());
    try {
      episodeRecord.setEpisode(Integer.parseInt(spinner_episode.getValue().toString()));
    } catch (NumberFormatException ex) {
      MySeriesLogger.logger.log(Level.WARNING, "Episode must be an integer");
      MyMessages.error("Not an integer", "Episode must be an integer");
      return;
    }
    if (textfield_title.getText().trim().equals("")) {
      MySeriesLogger.logger.log(Level.WARNING, "Episode title must not be blank");
      MyMessages.error("No Title!!!", "The episode title must not be blank");
      return;
    }
    episodeRecord.setSubs((Language) combobox_subtitles.getSelectedItem());
    episodeRecord.setSeen(checkbox_seen.isSelected() ? 1 : 0);
    episodeRecord.setDownloaded(checkbox_downloaded.isSelected() ? 1 : 0);
    SimpleDateFormat f = new SimpleDateFormat(EpisodesRecord.MYSQL_DATE_FORMAT);
    String aired;
    try {
      if (dateChooser.getDate() == null) {
        aired = f.format(Calendar.getInstance().getTime());
      } else {
        aired = f.format(dateChooser.getDate());
      }
      episodeRecord.setAired(aired);
      episodeRecord.save(new DBConnection().stmt);
      MySeriesLogger.logger.log(Level.INFO, "Episode {0} added", episodeRecord.getTitle());
      Episodes.getCurrentSeriesEpisodes(m.tableEpisodes);
      dispose();
      MySeries.glassPane.deactivate();
      MySeriesLogger.logger.log(Level.INFO, "Episode added");
    } catch (SQLException ex) {
      MySeriesLogger.logger.log(Level.SEVERE, "There was an error while writting the episode to the database", ex);
      MyMessages.error("SQL Error!!!", "There was an error while writting the episode to the database");
    } catch (NullPointerException ex) {
      MySeriesLogger.logger.log(Level.WARNING, "The date is not in the right format");
      MyMessages.error("Date Error!!!", "The date is not in the right format");
    }
  }

    private void textfield_titleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_titleKeyReleased
      textfield_title.validateValue();
    }//GEN-LAST:event_textfield_titleKeyReleased

    private void bt_helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_helpActionPerformed
      new HelpWindow(HelpWindow.ADMIN_EPISODES);
    }//GEN-LAST:event_bt_helpActionPerformed

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
      MySeriesLogger.logger.log(Level.INFO, "Action canceled by the user");
      dispose();
      MySeries.glassPane.deactivate();
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void bt_okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_okActionPerformed
      try {
        ValidationGroup group = new ValidationGroup();
        group.addComponent(textfield_title);
        MySeriesLogger.logger.log(Level.INFO, "Validating input");
        if (group.validate()) {
          addTheEpisode();
        } else {
          MySeriesLogger.logger.log(Level.WARNING, "Validating error\n{0}",group.getErrorMessage());
          MyMessages.error("Episodes Form", group.getErrorMessage());
        }
      } catch (IOException ex) {
        MySeriesLogger.logger.log(Level.SEVERE, "I/O exception occured", ex);
      } catch (ParseException ex) {
        MySeriesLogger.logger.log(Level.SEVERE, "Parse exception occured", ex);
      }
    }//GEN-LAST:event_bt_okActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private myComponents.myGUI.buttons.MyButtonCancel bt_cancel;
  private myComponents.myGUI.buttons.MyButtonHelp bt_help;
  private myComponents.myGUI.buttons.MyButtonOk bt_ok;
  private javax.swing.JCheckBox checkbox_downloaded;
  private javax.swing.JCheckBox checkbox_seen;
  private javax.swing.JComboBox combobox_subtitles;
  private com.toedter.calendar.JDateChooser dateChooser;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JLabel label_Date;
  private javax.swing.JLabel label_EpisodeNumber;
  private javax.swing.JLabel label_EpisodeTitle;
  private javax.swing.JLabel label_subtitles;
  private javax.swing.JLabel label_title;
  private javax.swing.JSpinner spinner_episode;
  private com.googlecode.svalidators.formcomponents.STextField textfield_title;
  // End of variables declaration//GEN-END:variables
}
