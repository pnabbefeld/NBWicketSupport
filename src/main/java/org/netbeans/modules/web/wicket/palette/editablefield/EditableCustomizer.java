/*
 * Not ready for public use, so <b>don't use it</b>, yet.
 */
package org.netbeans.modules.web.wicket.palette.editablefield;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.text.JTextComponent;
import org.openide.DialogDescriptor;
import org.openide.DialogDisplayer;
import org.openide.util.NbBundle;

/**
 *
 * @author Tim Boudreau
 */
public class EditableCustomizer extends JPanel {

    private Dialog dialog = null;
    private DialogDescriptor descriptor = null;
    private boolean dialogOK = false;
    Editable editable;
    JTextComponent target;
    private JTextField initialTextField;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JTextField placeholderTextField;
    private JTextField wicketIdTextField;

    public EditableCustomizer(Editable label, JTextComponent target) {
        this.editable = label;
        this.target = target;
        this.initComponents();
    }

    public boolean showDialog() {
        this.dialogOK = false;
        String displayName = "";
        try {
            displayName = NbBundle.getBundle((String)"org.netbeans.modules.web.wicket.palette.label.Bundle").getString("NAME_html-LABEL");
        } catch (Exception ex) {
            // empty catch block
        }
        this.descriptor = new DialogDescriptor(this, NbBundle.getMessage(EditableCustomizer.class, "LBL_Customizer_InsertPrefix") + " " + displayName, true, 2, DialogDescriptor.OK_OPTION, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (EditableCustomizer.this.descriptor.getValue().equals(DialogDescriptor.OK_OPTION)) {
                    EditableCustomizer.this.evaluateInput();
                    EditableCustomizer.this.dialogOK = true;
                }
                EditableCustomizer.this.dialog.dispose();
            }
        });
        this.dialog = DialogDisplayer.getDefault().createDialog(this.descriptor);
        this.dialog.setVisible(true);
        this.repaint();
        return this.dialogOK;
    }

    private void evaluateInput() {
        String wicketId = this.wicketIdTextField.getText();
        String placeholderText = this.placeholderTextField.getText();
        String initialValue = this.initialTextField.getText();
        this.editable.setWicketId(wicketId);
        this.editable.setPlaceholderText(placeholderText);
        this.editable.setInitialValue(initialValue);
    }

    private void initComponents() {
        this.jLabel1 = new JLabel();
        this.wicketIdTextField = new JTextField();
        this.jLabel2 = new JLabel();
        this.placeholderTextField = new JTextField();
        this.initialTextField = new JTextField();
        this.jLabel3 = new JLabel();
        this.jLabel1.setText(NbBundle.getMessage(EditableCustomizer.class, (String)"EditableCustomizer.jLabel1.text"));
        this.wicketIdTextField.setText(NbBundle.getMessage(EditableCustomizer.class, (String)"EditableCustomizer.wicketIdTextField.text"));
        this.jLabel2.setText(NbBundle.getMessage(EditableCustomizer.class, (String)"EditableCustomizer.jLabel2.text"));
        this.placeholderTextField.setText(NbBundle.getMessage(EditableCustomizer.class, (String)"EditableCustomizer.placeholderTextField.text"));
        this.initialTextField.setText(NbBundle.getMessage(EditableCustomizer.class, (String)"EditableCustomizer.initialTextField.text"));
        this.jLabel3.setText(NbBundle.getMessage(EditableCustomizer.class, (String)"EditableCustomizer.jLabel3.text"));
        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING).addComponent(this.jLabel1).addComponent(this.jLabel2).addComponent(this.jLabel3)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.wicketIdTextField, -1, 178, 32767).addComponent(this.placeholderTextField, -1, 178, 32767).addComponent(this.initialTextField, -1, 178, 32767)).addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel1).addComponent(this.wicketIdTextField, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.jLabel2).addComponent(this.placeholderTextField, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.initialTextField, -2, -1, -2).addComponent(this.jLabel3)).addContainerGap(-1, 32767)));
    }
}
