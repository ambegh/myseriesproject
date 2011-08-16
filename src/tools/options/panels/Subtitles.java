/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Subtitles.java
 *
 * Created on 20 Μαϊ 2011, 9:10:39 πμ
 */
package tools.options.panels;

import com.googlecode.svalidators.validators.CompareValidator;
import com.googlecode.svalidators.validators.SValidator;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import myComponents.myTableCellRenderers.MySubtitleListRenderer;
import tools.download.subtitles.SubtitleConstants;
import myseriesproject.MySeries;
import tools.options.IMySeriesOptions;

/**
 *
 * @author Spyros Soldatos
 */
public class Subtitles extends javax.swing.JPanel implements IMySeriesOptions {

  private ComboBoxModel primarySubtitlesModel = new DefaultComboBoxModel(SubtitleConstants.SUBTITLE_LANG.toArray());
  private ComboBoxModel secondarySubtitlesModel = new DefaultComboBoxModel(SubtitleConstants.SUBTITLE_LANG.toArray());

  /** Creates new form Subtitles */
  public Subtitles() {
    initComponents();
    combo_secondaryLang.addValidator(
        new CompareValidator(combo_secondaryLang.getSelectedItem() != null ? combo_secondaryLang.getSelectedItem().toString() : "",
        combo_primaryLang.getSelectedItem() != null ? combo_primaryLang.getSelectedItem().toString() : "",
        CompareValidator.Type.NOT_EQUAL, true));
    combo_primaryLang.setRenderer(new MySubtitleListRenderer());
    combo_secondaryLang.setRenderer(new MySubtitleListRenderer());
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jLabel13 = new javax.swing.JLabel();
    combo_primaryLang = new com.googlecode.svalidators.formcomponents.SComboBox();
    jLabel15 = new javax.swing.JLabel();
    combo_secondaryLang = new com.googlecode.svalidators.formcomponents.SComboBox();
    jCheckBox1 = new javax.swing.JCheckBox();

    setName("Subtitles"); // NOI18N

    jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel13.setText("Primary subtitles lang. :");
    jLabel13.setToolTipText("When downloading subtitles this language will be queried first.");
    jLabel13.setName("noname"); // NOI18N

    combo_primaryLang.setModel(primarySubtitlesModel);
    combo_primaryLang.setSelectedItem(MySeries.languages.getLanguageByName(MySeries.options.getStringOption(PRIMARY_SUB)));
    combo_primaryLang.setName(PRIMARY_SUB);
    combo_primaryLang.setOpaque(false);
    combo_primaryLang.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        combo_primaryLangActionPerformed(evt);
      }
    });

    jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel15.setText("Secondary subtitles lang. :");
    jLabel15.setToolTipText("When downloading subtitles this language will be queried first.");
    jLabel15.setName("noname"); // NOI18N

    combo_secondaryLang.setModel(secondarySubtitlesModel);
    combo_secondaryLang.setSelectedItem(MySeries.languages.getLanguageByName(MySeries.options.getStringOption(SECONDARY_SUB)));
    combo_secondaryLang.setMinimumSize(new java.awt.Dimension(23, 20));
    combo_secondaryLang.setName(SECONDARY_SUB);
    combo_secondaryLang.setOpaque(false);
    combo_secondaryLang.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        combo_secondaryLangActionPerformed(evt);
      }
    });

    jCheckBox1.setSelected(MySeries.options.getBooleanOption(SEARCH_FOR_SECONDARY_SUBTITLE));
    jCheckBox1.setText("Search for both languages subtitles");
    jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jCheckBox1.setName(SEARCH_FOR_SECONDARY_SUBTITLE);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(combo_primaryLang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(combo_secondaryLang, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING))
          .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(20, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jLabel13)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(combo_primaryLang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jLabel15)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(combo_secondaryLang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jCheckBox1)
        .addContainerGap(11, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void combo_primaryLangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_primaryLangActionPerformed
    CompareValidator val = (CompareValidator) combo_secondaryLang.getValidator(SValidator.COMPARE);
    val.setValueToCompareWith(combo_primaryLang.getSelectedItem().toString());
    val.setValue(combo_secondaryLang.getSelectedItem().toString());
    combo_secondaryLang.validateValue();
}//GEN-LAST:event_combo_primaryLangActionPerformed

  private void combo_secondaryLangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_secondaryLangActionPerformed
    combo_primaryLangActionPerformed(evt);
}//GEN-LAST:event_combo_secondaryLangActionPerformed
  // Variables declaration - do not modify//GEN-BEGIN:variables
  public com.googlecode.svalidators.formcomponents.SComboBox combo_primaryLang;
  public com.googlecode.svalidators.formcomponents.SComboBox combo_secondaryLang;
  private javax.swing.JCheckBox jCheckBox1;
  private javax.swing.JLabel jLabel13;
  private javax.swing.JLabel jLabel15;
  // End of variables declaration//GEN-END:variables
}
