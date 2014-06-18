/*******************************************************************************
 * Copyright 2012-2014 Esri
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 ******************************************************************************/
package com.esri.vehiclecommander.view;

import com.esri.map.Layer;
import com.esri.vehiclecommander.model.BasemapLayer;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;

/**
 * A panel that lets the user select a basemap to display.
 */
public class BasemapsJPanel extends RoundedJPanel implements BasemapListener {
    
    private List<BasemapLayer> layers;

    public BasemapsJPanel() {
        initComponents();
    }
    
    public void setBasemapLayers(final List<BasemapLayer> layers) {
        this.layers = layers;
        
        jPanel_widgets.removeAll();
        Enumeration<AbstractButton> buttons = buttonGroup_basemaps.getElements();
        while (buttons.hasMoreElements()) {
            buttonGroup_basemaps.remove(buttons.nextElement());
        }
        for (BasemapLayer layer : layers) {
            BasemapWidget widget = new BasemapWidget(layer, buttonGroup_basemaps);
            widget.addBasemapListener(this);
            jPanel_widgets.add(widget);
        }
        
        //Resize based on contents
        jPanel_widgets.setSize(jPanel_widgets.getLayout().preferredLayoutSize(jPanel_widgets));
        setSize(getLayout().preferredLayoutSize(this));
    }

    /**
     * Called when a basemap widget is selected, and turns off all other basemap
     * layers.
     * @see BasemapListener
     * @param layer the layer that became visible.
     */
    public void basemapBecameVisible(Layer layer) {
        for (BasemapLayer basemapLayer : layers) {
            if (basemapLayer.getLayer() != layer) {
                basemapLayer.getLayer().setVisible(false);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_basemaps = new javax.swing.ButtonGroup();
        jLabel_mainMenu = new javax.swing.JLabel();
        jButton_close = new javax.swing.JButton();
        jPanel_widgets = new javax.swing.JPanel();

        jLabel_mainMenu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_mainMenu.setText("Basemaps");

        jButton_close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esri/vehiclecommander/resources/X-Normal.png"))); // NOI18N
        jButton_close.setBorderPainted(false);
        jButton_close.setContentAreaFilled(false);
        jButton_close.setFocusable(false);
        jButton_close.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton_close.setMaximumSize(new java.awt.Dimension(50, 50));
        jButton_close.setMinimumSize(new java.awt.Dimension(50, 50));
        jButton_close.setPreferredSize(new java.awt.Dimension(50, 50));
        jButton_close.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esri/vehiclecommander/resources/X-Pressed.png"))); // NOI18N
        jButton_close.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/esri/vehiclecommander/resources/X-Pressed.png"))); // NOI18N
        jButton_close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_closeActionPerformed(evt);
            }
        });

        jPanel_widgets.setOpaque(false);
        jPanel_widgets.setLayout(new java.awt.GridLayout(0, 3));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel_widgets, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel_mainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton_close, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_mainMenu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel_widgets, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_closeActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton_closeActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup_basemaps;
    private javax.swing.JButton jButton_close;
    private javax.swing.JLabel jLabel_mainMenu;
    private javax.swing.JPanel jPanel_widgets;
    // End of variables declaration//GEN-END:variables

}