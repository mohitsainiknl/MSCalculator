package handler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import handler.gui.CalcField;

/**
 * ActionHandler
 */
public class ActionHandler implements ActionListener {
    private CalcField mainField, subField;

    public ActionHandler(CalcField mainField, CalcField subField) {
        this.mainField  = mainField;
        this.subField = subField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}