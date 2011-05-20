/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Internet.java
 *
 * Created on 19 Μαϊ 2011, 7:06:26 μμ
 */
package tools.options.panels;

import com.googlecode.svalidators.validators.CompareValidator;
import com.googlecode.svalidators.validators.NoSpaceValidator;
import com.googlecode.svalidators.validators.NullValidator;
import com.googlecode.svalidators.validators.PositiveNumberValidator;
import com.googlecode.svalidators.validators.SValidator;
import java.util.Hashtable;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import myComponents.myTableCellRenderers.MySubtitleListRenderer;
import tools.download.subtitles.SubtitleConstants;
import tools.options.Options;
import myseries.MySeries;

/**
 *
 * @author lordovol
 */
public class Internet extends javax.swing.JPanel {

  
  /** Creates new form Internet */
  public Internet() {
    initComponents();
    addSliderLabels();
    checkbox_useProxyActionPerformed(null);
  }

  private void addSliderLabels() {
    Hashtable<Integer, JLabel> labelTable = new Hashtable();
    labelTable = new Hashtable();
    labelTable.put(new Integer(0), new JLabel("0"));
    labelTable.put(new Integer(10), new JLabel("10"));
    labelTable.put(new Integer(20), new JLabel("20"));
    labelTable.put(new Integer(30), new JLabel("30"));
    labelTable.put(new Integer(40), new JLabel("40"));
    labelTable.put(new Integer(50), new JLabel("50"));
    labelTable.put(new Integer(60), new JLabel("60"));
    sl_feeds.setLabelTable(labelTable);
    sl_feeds.setPaintLabels(true);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

    checkbox_useProxy = new javax.swing.JCheckBox();
    jLabel8 = new javax.swing.JLabel();
    jLabel9 = new javax.swing.JLabel();
    textfield_proxy = new com.googlecode.svalidators.formcomponents.STextField(new NoSpaceValidator("",false));
    jCheckBox1 = new javax.swing.JCheckBox();
    textfield_port = new com.googlecode.svalidators.formcomponents.STextField(new PositiveNumberValidator("",false,false));
    jLabel2 = new javax.swing.JLabel();
    spinner_columns = new javax.swing.JSpinner();
    cb_updateFeeds = new javax.swing.JCheckBox();
    jLabel26 = new javax.swing.JLabel();
    jLabel27 = new javax.swing.JLabel();
    sl_feeds = new javax.swing.JSlider();

    setName("Internet"); // NOI18N

    checkbox_useProxy.setSelected(Options.toBoolean(Options.USE_PROXY));
    checkbox_useProxy.setText("Use Proxy");
    checkbox_useProxy.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    checkbox_useProxy.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    checkbox_useProxy.setMargin(new java.awt.Insets(0, 0, 0, 0));
    checkbox_useProxy.setName(Options.USE_PROXY);
    checkbox_useProxy.setOpaque(false);
    checkbox_useProxy.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkbox_useProxyActionPerformed(evt);
      }
    });

    jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel8.setText("Http proxy :");
    jLabel8.setName("noname"); // NOI18N

    jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel9.setText("Port :");
    jLabel9.setName("noname"); // NOI18N

    textfield_proxy.setText(Options.toString(Options.PROXY_HOST));
    textfield_proxy.setName(Options.PROXY_HOST);
    textfield_proxy.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        textfield_proxyKeyReleased(evt);
      }
    });

    jCheckBox1.setSelected(Options.toBoolean(Options.CHECK_VERSION));
    jCheckBox1.setText("Check for updates on startup");
    jCheckBox1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jCheckBox1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    jCheckBox1.setMargin(new java.awt.Insets(0, 0, 0, 0));
    jCheckBox1.setName(Options.CHECK_VERSION);
    jCheckBox1.setOpaque(false);

    textfield_port.setText(Options.toString(Options.PROXY_PORT));
    textfield_port.setName(Options.PROXY_PORT);
    textfield_port.addKeyListener(new java.awt.event.KeyAdapter() {
      public void keyReleased(java.awt.event.KeyEvent evt) {
        textfield_portKeyReleased(evt);
      }
    });

    jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel2.setText("Number of columns in Feeds :");

    spinner_columns.setName(Options.FEED_COLUMNS);
    spinner_columns.setValue(Options.toInt(Options.FEED_COLUMNS));

    cb_updateFeeds.setSelected(Options.toBoolean(Options.UPDATE_FEEDS));
    cb_updateFeeds.setText("Update feeds on startup");
    cb_updateFeeds.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    cb_updateFeeds.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
    cb_updateFeeds.setMargin(new java.awt.Insets(0, 0, 0, 0));
    cb_updateFeeds.setName(Options.UPDATE_FEEDS);
    cb_updateFeeds.setOpaque(false);

    jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

    org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sl_feeds, org.jdesktop.beansbinding.ELProperty.create("Update feeds every ${value} min"), jLabel26, org.jdesktop.beansbinding.BeanProperty.create("text"));
    bindingGroup.addBinding(binding);

    jLabel27.setFont(jLabel27.getFont().deriveFont((jLabel27.getFont().getStyle() | java.awt.Font.ITALIC)));
    jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
    jLabel27.setText("(Set it to 0 to deactivate it)");

    sl_feeds.setMajorTickSpacing(10);
    sl_feeds.setMaximum(60);
    sl_feeds.setMinorTickSpacing(1);
    sl_feeds.setPaintTicks(true);
    sl_feeds.setSnapToTicks(true);
    sl_feeds.setToolTipText("Frequency of memory consumption update");
    sl_feeds.setValue(Options.toInt(Options.FEED_UPDATE_FREQUENCY));
    sl_feeds.setName(Options.FEED_UPDATE_FREQUENCY);
    sl_feeds.setOpaque(false);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(checkbox_useProxy, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                  .addComponent(cb_updateFeeds)
                  .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spinner_columns, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
              .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                  .addComponent(textfield_proxy, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                  .addComponent(textfield_port, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)))
            .addGap(50, 50, 50))
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(sl_feeds, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(50, Short.MAX_VALUE))
          .addGroup(layout.createSequentialGroup()
            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(135, Short.MAX_VALUE))))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel2)
          .addComponent(spinner_columns, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(9, 9, 9)
        .addComponent(cb_updateFeeds)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(sl_feeds, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(18, 18, 18)
        .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(42, 42, 42)
        .addComponent(checkbox_useProxy, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addGap(9, 9, 9)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel8)
          .addComponent(textfield_proxy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel9)
          .addComponent(textfield_port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(13, Short.MAX_VALUE))
    );

    bindingGroup.bind();
  }// </editor-fold>//GEN-END:initComponents

    private void checkbox_useProxyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkbox_useProxyActionPerformed
      textfield_port.clearValidatorsList();
      textfield_proxy.clearValidatorsList();
      if (!checkbox_useProxy.isSelected()) {
        textfield_port.addValidator(new NullValidator());
        textfield_proxy.addValidator(new NullValidator());
      } else {
        textfield_port.addValidator(new PositiveNumberValidator(Options.toString(Options.PROXY_PORT), false, false));
        textfield_proxy.addValidator(new NoSpaceValidator(Options.toString(Options.PROXY_HOST), false));
      }
      textfield_port.validateValue();
      textfield_proxy.validateValue();
}//GEN-LAST:event_checkbox_useProxyActionPerformed

    private void textfield_proxyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_proxyKeyReleased
      textfield_proxy.validateValue();
}//GEN-LAST:event_textfield_proxyKeyReleased

    private void textfield_portKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textfield_portKeyReleased
      textfield_port.validateValue();
}//GEN-LAST:event_textfield_portKeyReleased

  // Variables declaration - do not modify//GEN-BEGIN:variables
  public javax.swing.JCheckBox cb_updateFeeds;
  public javax.swing.JCheckBox checkbox_useProxy;
  public javax.swing.JCheckBox jCheckBox1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel26;
  private javax.swing.JLabel jLabel27;
  private javax.swing.JLabel jLabel8;
  private javax.swing.JLabel jLabel9;
  public javax.swing.JSlider sl_feeds;
  public javax.swing.JSpinner spinner_columns;
  public com.googlecode.svalidators.formcomponents.STextField textfield_port;
  public com.googlecode.svalidators.formcomponents.STextField textfield_proxy;
  private org.jdesktop.beansbinding.BindingGroup bindingGroup;
  // End of variables declaration//GEN-END:variables
}
