/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.univali.ps.ui.telas;

import br.univali.ps.ui.utils.IconFactory;
import br.univali.ps.ui.window.DialogBorderPanel;
import br.univali.ps.ui.window.OuterStaticPanel;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 *
 * @author lite
 */
public class TelaCustomBorder extends javax.swing.JDialog
{
    private Action acaoSair;
    private String titulo;
    private JPanel panel;
    private DialogBorderPanel borderPanel;

    public TelaCustomBorder(JPanel jPanel, String titulo)
    {
        super();
        initComponents();
        configurarAcaoSair();
        setModal(true);
        dispose();
        setUndecorated(true);
        setLayout(new BorderLayout());
        this.titulo = titulo;
        
        if (jPanel != null)
        {
            configurePanel(jPanel, titulo, true);
        }
    }
    
    private void configurePanel(JPanel jPanel, String titulo, boolean pack)
    {
        this.borderPanel=new DialogBorderPanel(acaoSair, this,titulo);
        add(new OuterStaticPanel(jPanel, borderPanel), BorderLayout.CENTER);
        
        if (pack)
        {
            pack();
        }
    }

    public Action getAcaoSair()
    {
        return acaoSair;
    }    
    
    public TelaCustomBorder(String titulo)
    {
        this(null, titulo);
    }
    
    public void setPanel(JPanel jPanel)
    {
        setPanel(jPanel, true);
    }
            
    public void setPanel(JPanel jPanel, boolean pack)
    {
        this.panel = jPanel;
        configurePanel(jPanel, this.titulo, pack);
    }

    public JPanel getPanel() {
        return panel;
    }
    
    @Override
    public void setTitle(String title)
    {
        this.borderPanel.setTitle(title);
    }
    
    private void configurarAcaoSair()
    {
        String nome = "Sair";
        KeyStroke atalho = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);

        acaoSair = new AbstractAction(nome, IconFactory.createIcon(IconFactory.CAMINHO_ICONES_GRANDES, "sair.png"))
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                setVisible(false);
            }
        };

        getRootPane().getActionMap().put(nome, acaoSair);
        getRootPane().getInputMap().put(atalho, nome);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(400, 300));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
