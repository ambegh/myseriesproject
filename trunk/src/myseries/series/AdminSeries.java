/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AddSeries.java
 *
 * Created on 30 Οκτ 2008, 8:04:57 μμ
 */
package myseries.series;

import myComponents.myGUI.CopyScreenshot;
import java.io.IOException;
import myComponents.MyUsefulFunctions;
import database.SeriesRecord;
import java.awt.Cursor;
import java.awt.Dialog.ModalityType;
import java.awt.Image;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.SpinnerNumberModel;
import myComponents.MyMessages;
import myComponents.myFileFilters.ScreenshotFilter;
import myComponents.myGUI.MyDraggable;
import myComponents.myGUI.MyWaitMessage;
import myseries.MySeries;
import com.googlecode.svalidators.formcomponents.STextField;
import com.googlecode.svalidators.formcomponents.ValidationGroup;
import com.googlecode.svalidators.validators.FileValidator;
import com.googlecode.svalidators.validators.NoSpaceValidator;
import com.googlecode.svalidators.validators.PositiveNumberValidator;
import com.googlecode.svalidators.validators.RequiredValidator;
import myseries.actions.Actions;
import myseries.actions.SeriesActions;
import tools.download.subtitles.sonline.GetSubtitleOnlineCode;
import tools.download.subtitles.tvsubtitles.GetTvSubtitlesCode;
import tools.internetUpdate.InternetUpdate;
import tools.internetUpdate.tvrage.TrGetId;

/**
 * Administrate series
 * @author lordovol
 */
public class AdminSeries extends MyDraggable {

  private final static long serialVersionUID = 43547453657578L;
  /**
   * MySeries main form
   */
  private MySeries m;
  /**
   * The series season
   */
  private int season;
  /**
   * The series title
   */
  private String serial;
  /**
   * The series record
   */
  private SeriesRecord seriesRecord;
  /**
   * The screenshot
   */
  private String screenshot;

  /**
   * Creates the adminSeries form
   * @param m The main mySeries form
   * @throws java.sql.SQLException
   */
  AdminSeries(MySeries m) throws SQLException {
    this.m = m;
    initComponents();
    setLocationRelativeTo(m);

  }

  /**
   * Creates the adminSeries form
   * @param m The main mySeries form
   * @param seriesRecord The series to edit.If null it creates a new series
   * @throws java.sql.SQLException
   */
  public AdminSeries(MySeries m, SeriesRecord seriesRecord) throws SQLException {
    this.m = m;
    this.seriesRecord = seriesRecord;
    initComponents();
    setLocationRelativeTo(m);
    spinner_season.setModel(new SpinnerNumberModel(Series.DEFAULT_SEASON, Series.MINIMUM_SEASON, Series.MAXIMUM_SEASON, Series.SEASON_STEP));
    if (seriesRecord != null) {
      spinner_season.setValue(seriesRecord.getSeason());
      textField_Serial.setText(seriesRecord.getTitle());
      label_Title.setText("Edit Series " + seriesRecord.getTitle()
              + " S" + MyUsefulFunctions.padLeft(seriesRecord.getSeason(), 2, "0"));
      textfield_tvSubsId.setText(seriesRecord.getTvSubtitlesCode());
      textfield_tvRageID.setText(String.valueOf(seriesRecord.getTvrage_ID()));
      textfield_localDir.setText(seriesRecord.getLocalDir());

      textfield_screenshot.setText(seriesRecord.getScreenshot().equals("")? "" : "./images/"+seriesRecord.getScreenshot());

      textfield_tvSubsId.setText(seriesRecord.getTvSubtitlesCode());
      textfield_subsOnline.setText(seriesRecord.getSOnlineCode());
      button_Add.setText("Edit");
    } else {
      label_Title.setText("Add New Series");
    }
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

    jPanel1 = new javax.swing.JPanel();
    label_Title = new javax.swing.JLabel();
    button_Add = new javax.swing.JButton();
    button_Cancel = new javax.swing.JButton();
    label_title = new javax.swing.JLabel();
    textField_Serial = new STextField(new RequiredValidator());
    label_season = new javax.swing.JLabel();
    spinner_season = new javax.swing.JSpinner();
    label_tvsubsId = new javax.swing.JLabel();
    label_tvrageId = new javax.swing.JLabel();
    textfield_tvRageID = new STextField(new PositiveNumberValidator("",true,true));
    button_getTvRageID = new javax.swing.JButton();
    label_localDir = new javax.swing.JLabel();
    button_browse = new javax.swing.JButton();
    label_screenshot = new javax.swing.JLabel();
    button_browseScreenshot = new javax.swing.JButton();
    label_subOnlineId = new javax.swing.JLabel();
    button_getTvSubtitlesId = new javax.swing.JButton();
    button_getSubOnlineId = new javax.swing.JButton();
    label_message = new javax.swing.JLabel();
    textfield_localDir = new com.googlecode.svalidators.formcomponents.STextField(new FileValidator("",FileValidator.Type.DIR,true));
    button_browseScreenshot1 = new javax.swing.JButton();
    textfield_screenshot = new com.googlecode.svalidators.formcomponents.STextField(new FileValidator("", FileValidator.Type.FILE, true));
    textfield_subsOnline = new com.googlecode.svalidators.formcomponents.STextField(new NoSpaceValidator("",true));
    textfield_tvSubsId = new com.googlecode.svalidators.formcomponents.STextField(new NoSpaceValidator("",true));
    jLabel1 = new javax.swing.JLabel();
    checkbox_updateEpisodes = new javax.swing.JCheckBox();

    setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
    setBackground(new java.awt.Color(102, 102, 102));
    setResizable(false);

    jPanel1.setBackground(new java.awt.Color(255, 255, 255));
    jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
    jPanel1.setOpaque(false);

    label_Title.setFont(label_Title.getFont().deriveFont(label_Title.getFont().getStyle() | java.awt.Font.BOLD, label_Title.getFont().getSize()+2));
    label_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    label_Title.setText("Add A New Series");

    button_Add.setText("Add");
    button_Add.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_AddActionPerformed(evt);
      }
    });

    button_Cancel.setText("Cancel");
    button_Cancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_CancelActionPerformed(evt);
      }
    });

    label_title.setFont(label_title.getFont());
    label_title.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_title.setText("Title:");

    textField_Serial.setName("Title"); // NOI18N

    label_season.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_season.setText("Season :");

    label_tvsubsId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_tvsubsId.setText("TvSubtitles ID :");

    label_tvrageId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_tvrageId.setText("TvRage ID :");

    textfield_tvRageID.setName("TvRage ID"); // NOI18N

    button_getTvRageID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/internet_update_small.png"))); // NOI18N
    button_getTvRageID.setToolTipText("Get ID for TvRage.com");
    button_getTvRageID.setIconTextGap(2);
    button_getTvRageID.setMaximumSize(new java.awt.Dimension(31, 25));
    button_getTvRageID.setMinimumSize(new java.awt.Dimension(31, 25));
    button_getTvRageID.setOpaque(false);
    button_getTvRageID.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        button_getTvRageIDMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        button_getTvRageIDMouseExited(evt);
      }
    });
    button_getTvRageID.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_getTvRageIDActionPerformed(evt);
      }
    });

    label_localDir.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_localDir.setText("Local Dir :");

    button_browse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/localDir_small.png"))); // NOI18N
    button_browse.setMaximumSize(new java.awt.Dimension(31, 25));
    button_browse.setMinimumSize(new java.awt.Dimension(31, 25));
    button_browse.setPreferredSize(new java.awt.Dimension(31, 25));
    button_browse.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_browseActionPerformed(evt);
      }
    });

    label_screenshot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_screenshot.setText("Screenshot :");

    button_browseScreenshot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/localDir_small.png"))); // NOI18N
    button_browseScreenshot.setMaximumSize(new java.awt.Dimension(31, 25));
    button_browseScreenshot.setMinimumSize(new java.awt.Dimension(31, 25));
    button_browseScreenshot.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_browseScreenshotActionPerformed(evt);
      }
    });

    label_subOnlineId.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    label_subOnlineId.setText("SubtitleOnline ID :");

    button_getTvSubtitlesId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/internet_update_small.png"))); // NOI18N
    button_getTvSubtitlesId.setToolTipText("Get ID for TvSubtitles.net");
    button_getTvSubtitlesId.setIconTextGap(2);
    button_getTvSubtitlesId.setMaximumSize(new java.awt.Dimension(31, 25));
    button_getTvSubtitlesId.setMinimumSize(new java.awt.Dimension(31, 25));
    button_getTvSubtitlesId.setOpaque(false);
    button_getTvSubtitlesId.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        button_getTvSubtitlesIdMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        button_getTvSubtitlesIdMouseExited(evt);
      }
    });
    button_getTvSubtitlesId.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_getTvSubtitlesIdActionPerformed(evt);
      }
    });

    button_getSubOnlineId.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/internet_update_small.png"))); // NOI18N
    button_getSubOnlineId.setToolTipText("Get ID for SubtitleOnline.com");
    button_getSubOnlineId.setIconTextGap(2);
    button_getSubOnlineId.setMaximumSize(new java.awt.Dimension(31, 25));
    button_getSubOnlineId.setMinimumSize(new java.awt.Dimension(31, 25));
    button_getSubOnlineId.setOpaque(false);
    button_getSubOnlineId.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseEntered(java.awt.event.MouseEvent evt) {
        button_getSubOnlineIdMouseEntered(evt);
      }
      public void mouseExited(java.awt.event.MouseEvent evt) {
        button_getSubOnlineIdMouseExited(evt);
      }
    });
    button_getSubOnlineId.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_getSubOnlineIdActionPerformed(evt);
      }
    });

    textfield_localDir.setName("Local Directory"); // NOI18N

    button_browseScreenshot1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/localDir_small.png"))); // NOI18N
    button_browseScreenshot1.setMaximumSize(new java.awt.Dimension(31, 25));
    button_browseScreenshot1.setMinimumSize(new java.awt.Dimension(31, 25));
    button_browseScreenshot1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        button_browseScreenshot1ActionPerformed(evt);
      }
    });

    textfield_screenshot.setName("Screenshot"); // NOI18N

    textfield_subsOnline.setName("SubtitleOnline ID"); // NOI18N

    textfield_tvSubsId.setName("TvSubtitles ID"); // NOI18N

    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
    jLabel1.setText("Update episodes list :");

    checkbox_updateEpisodes.setSelected(true);
    checkbox_updateEpisodes.setMargin(new java.awt.Insets(0, 0, 0, 0));
    checkbox_updateEpisodes.setOpaque(false);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(label_tvsubsId, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                  .addComponent(label_subOnlineId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_season, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(label_title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(button_Add, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_Cancel, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                .addGap(50, 50, 50))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(label_localDir, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(label_screenshot, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
              .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                  .addComponent(label_tvrageId, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(textfield_localDir, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                  .addComponent(textField_Serial, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                  .addComponent(spinner_season, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(textfield_tvSubsId, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(textfield_subsOnline, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                      .addComponent(textfield_tvRageID, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                      .addComponent(button_getTvSubtitlesId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(button_getSubOnlineId, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                      .addComponent(button_getTvRageID, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(label_message, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                  .addComponent(textfield_screenshot, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(button_browseScreenshot, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(button_browseScreenshot1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                  .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(button_browse, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addGap(47, 47, 47))))
              .addComponent(checkbox_updateEpisodes)))
          .addComponent(label_Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
        .addContainerGap())
    );

    jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {button_browse, button_browseScreenshot, button_getSubOnlineId, button_getTvRageID, button_getTvSubtitlesId});

    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(label_Title)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(label_title, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(textField_Serial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(label_season)
          .addComponent(spinner_season, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
          .addComponent(button_browse, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
          .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(label_localDir)
            .addComponent(textfield_localDir, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGap(16, 16, 16)
            .addComponent(button_browseScreenshot1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(button_browseScreenshot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
              .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textfield_screenshot, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                .addComponent(label_screenshot, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addComponent(label_message, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
            .addGap(20, 20, 20))
          .addGroup(jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(label_tvsubsId)
              .addComponent(textfield_tvSubsId, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
              .addComponent(button_getTvSubtitlesId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(label_subOnlineId)
              .addComponent(textfield_subsOnline, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(button_getSubOnlineId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
              .addComponent(label_tvrageId)
              .addComponent(textfield_tvRageID, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
              .addComponent(button_getTvRageID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel1)
              .addComponent(checkbox_updateEpisodes))))
        .addGap(11, 11, 11)
        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(button_Cancel)
          .addComponent(button_Add))
        .addContainerGap())
    );

    jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {button_getSubOnlineId, button_getTvRageID, button_getTvSubtitlesId, spinner_season, textField_Serial, textfield_localDir, textfield_screenshot, textfield_subsOnline, textfield_tvRageID, textfield_tvSubsId});

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

    private void button_CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_CancelActionPerformed
      MySeries.glassPane.deactivate();
      dispose();
    }//GEN-LAST:event_button_CancelActionPerformed

  /**
   * Adds the series in the database
   * @throws java.io.IOException
   */
  private void addSeries() {
    if (textField_Serial.getText().trim().equals("")) {
      MySeries.logger.log(Level.WARNING, "You must type the title");
      MyMessages.error("No Title!!!", "You must type the title");
    } else if (String.valueOf(spinner_season.getValue()).trim().equals("")) {
      MySeries.logger.log(Level.WARNING, "You must type the season");
      MyMessages.error("No Season!!!", "You must type the season");
    } else {
      try {
        int tvRageID = 0;
        try {
          tvRageID = Integer.parseInt(textfield_tvRageID.getText());
        } catch (NumberFormatException ex) {
        }
        screenshot = textfield_screenshot.getText().trim();
        season = Integer.parseInt(String.valueOf(spinner_season.getValue()).trim());
        serial = textField_Serial.getText().trim();
        if (Series.getCurrentSerial().getSeries_ID() == 0) {
          seriesRecord = new SeriesRecord();
        }
        seriesRecord.setTitle(serial);
        seriesRecord.setSeason(season);
        seriesRecord.setTvSubtitlesCode(textfield_tvSubsId.getText().trim());
        seriesRecord.setTvrage_ID(tvRageID);
        seriesRecord.setLocalDir(textfield_localDir.getText());
        seriesRecord.setTvSubtitlesCode(textfield_tvSubsId.getText().trim());
        seriesRecord.setSOnlineCode(textfield_subsOnline.getText().trim());
        try {
          File sc = new File(screenshot);
          if (sc.isFile() && !screenshot.startsWith("./images")) {
            CopyScreenshot c = new CopyScreenshot(screenshot);
            Thread t = new Thread(c);
            t.start();
          }
          seriesRecord.setScreenshot(sc.getName());
          int series_ID = seriesRecord.save();
          seriesRecord.setSeries_ID(series_ID);
          m.imagePanel.relocate(m);
          Series.getSeries();
          MySeries.glassPane.deactivate();
          dispose();
          Image im = new ImageIcon(sc.getAbsolutePath()).getImage();
          m.imagePanel.setImage(im);
          Series.setCurrentSerial(seriesRecord);
          SeriesActions.internetUpdateSeries(m, InternetUpdate.TV_RAGE_NAME);
        } catch (SQLException ex) {
          MySeries.logger.log(Level.SEVERE, "SQL error occured", ex);
        }
      } catch (NumberFormatException ex) {
        MySeries.logger.log(Level.WARNING, "Season must be a number", ex);
        MyMessages.error("Season not a number!!!", "Season must be a number");
      }
    }
  }

    private void button_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_AddActionPerformed
      ValidationGroup group = new ValidationGroup();
      group.addComponent(textField_Serial);
      group.addComponent(textfield_subsOnline);
      group.addComponent(textfield_tvSubsId);
      group.addComponent(textfield_tvRageID);
      group.addComponent(textfield_localDir);
      group.addComponent(textfield_screenshot);
      if(!group.validate()){
        group.errorMessage(true);
        return;
      }
      addSeries();

    }//GEN-LAST:event_button_AddActionPerformed

    private void button_getTvRageIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_getTvRageIDActionPerformed
      setModalityType(ModalityType.MODELESS);
      dispose();
      TrGetId g = new TrGetId(this, textField_Serial.getText().trim());
      //setVisible(true);
      //textfield_tvRageID.setText(String.valueOf(g.tvRageID));
    }//GEN-LAST:event_button_getTvRageIDActionPerformed

    private void button_getTvRageIDMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_getTvRageIDMouseEntered
      setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_button_getTvRageIDMouseEntered

    private void button_getTvRageIDMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_getTvRageIDMouseExited
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_button_getTvRageIDMouseExited

    private void button_browseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_browseActionPerformed
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File(textfield_localDir.getText()));
      fc.setDialogTitle("Choose the Series directory");
      fc.setDialogType(JFileChooser.OPEN_DIALOG);
      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      fc.showOpenDialog(this);
      File localDir = fc.getSelectedFile();
      textfield_localDir.setText(localDir.getAbsolutePath());
    }//GEN-LAST:event_button_browseActionPerformed

    private void button_browseScreenshotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_browseScreenshotActionPerformed
      JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File("./"));
      fc.setDialogTitle("Choose the Series screenshot");
      fc.setDialogType(JFileChooser.OPEN_DIALOG);
      fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
      fc.setFileFilter(new ScreenshotFilter());
      fc.showOpenDialog(this);
      File fScreenshot = fc.getSelectedFile();
      textfield_screenshot.setText(fScreenshot.getAbsolutePath());
    }//GEN-LAST:event_button_browseScreenshotActionPerformed

    private void button_getTvSubtitlesIdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_getTvSubtitlesIdMouseEntered
      setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_button_getTvSubtitlesIdMouseEntered

    private void button_getTvSubtitlesIdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_getTvSubtitlesIdMouseExited
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_button_getTvSubtitlesIdMouseExited

    private void button_getTvSubtitlesIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_getTvSubtitlesIdActionPerformed
      if (seriesRecord == null) {
        if (textField_Serial.getText().trim().equals("")) {
          MyMessages.error("Empty title", "The series title shouldn't be empty");
          return;
        } else {
          seriesRecord = new SeriesRecord();
          seriesRecord.setTitle(textField_Serial.getText().trim());
          seriesRecord.setSeason(Integer.parseInt(String.valueOf(spinner_season.getValue())));
        }
      }
      setModalityType(ModalityType.MODELESS);
      setVisible(false);
      MyWaitMessage message = new MyWaitMessage(null, false, "Please wait while searching for tvSubtitleCode");
      message.create();
      GetTvSubtitlesCode c = new GetTvSubtitlesCode(seriesRecord);
      message.destroy();
      String id = c.tSubCode;
      if (id == null) {
      } else {
        textfield_tvSubsId.setText(c.tSubCode);
        label_message.setText("");
        label_message.setText("");
      }
      setVisible(true);
    }//GEN-LAST:event_button_getTvSubtitlesIdActionPerformed

    private void button_getSubOnlineIdMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_getSubOnlineIdMouseEntered
      setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_button_getSubOnlineIdMouseEntered

    private void button_getSubOnlineIdMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button_getSubOnlineIdMouseExited
      setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_button_getSubOnlineIdMouseExited

    private void button_getSubOnlineIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_getSubOnlineIdActionPerformed
      setModalityType(ModalityType.MODELESS);
      setVisible(false);
      MyWaitMessage message = new MyWaitMessage(null, false, "Please wait while searching for SubtitleOnline");
      message.create();
      GetSubtitleOnlineCode c = new GetSubtitleOnlineCode(seriesRecord);
      message.destroy();
      String id = c.tSubCode;
      if (id == null) {
      } else {
        textfield_subsOnline.setText(c.tSubCode);
        label_message.setText("");
        label_message.setText("");
      }
      setVisible(true);
    }//GEN-LAST:event_button_getSubOnlineIdActionPerformed

    private void button_browseScreenshot1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_browseScreenshot1ActionPerformed
       JFileChooser fc = new JFileChooser();
      fc.setCurrentDirectory(new File(textfield_localDir.getText()));
      fc.setDialogTitle("Choose the Series directory");
      fc.setDialogType(JFileChooser.OPEN_DIALOG);
      fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
      fc.showOpenDialog(this);
      File localDir = fc.getSelectedFile();
      textfield_localDir.setText(localDir.getAbsolutePath());
    }//GEN-LAST:event_button_browseScreenshot1ActionPerformed

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton button_Add;
  private javax.swing.JButton button_Cancel;
  private javax.swing.JButton button_browse;
  private javax.swing.JButton button_browseScreenshot;
  private javax.swing.JButton button_browseScreenshot1;
  private javax.swing.JButton button_getSubOnlineId;
  private javax.swing.JButton button_getTvRageID;
  private javax.swing.JButton button_getTvSubtitlesId;
  private javax.swing.JCheckBox checkbox_updateEpisodes;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JLabel label_Title;
  private javax.swing.JLabel label_localDir;
  private javax.swing.JLabel label_message;
  private javax.swing.JLabel label_screenshot;
  private javax.swing.JLabel label_season;
  private javax.swing.JLabel label_subOnlineId;
  private javax.swing.JLabel label_title;
  private javax.swing.JLabel label_tvrageId;
  private javax.swing.JLabel label_tvsubsId;
  private javax.swing.JSpinner spinner_season;
  private com.googlecode.svalidators.formcomponents.STextField textField_Serial;
  private com.googlecode.svalidators.formcomponents.STextField textfield_localDir;
  private com.googlecode.svalidators.formcomponents.STextField textfield_screenshot;
  private com.googlecode.svalidators.formcomponents.STextField textfield_subsOnline;
  public com.googlecode.svalidators.formcomponents.STextField textfield_tvRageID;
  private com.googlecode.svalidators.formcomponents.STextField textfield_tvSubsId;
  // End of variables declaration//GEN-END:variables
}
