package Sortings;
import java.awt.Toolkit;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        About.java
 * Description  About form for the Searchinmg and Sorting Project
 * Project      Searchinmg and Sorting
 * Platform     jdk 1.8.0_214; NetBeans IDE 11.3; Windows 10
 * Course       CS 142, EdCC
 * Hourse       1 hours and 5 minutes
 * Date         4/17/2020
 * Histoly log  
 * @author	<i>Niko Culevski</i>
 * @version 	%1% %0%
 * @see     	javax.swing.JDialog 
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class About extends javax.swing.JDialog
{
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
     * Constructor  JDialog to allow to select modal or modeless form
     * Description  Create the form as designed, center it, set the icon, 
     *              closeJButton as default.
     * Date         3/31/2020
     * History log  4/4/2016, 1/4/2019
     * @author      <i>Niko Culevski</i>
     * @param       parent java.awt.Frame parent
     * @param       modal boolean
     *</pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public About(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        //set buttonAdd as default
        this.getRootPane().setDefaultButton(closeJButton); 
        this.setLocationRelativeTo(null);       //center form
        this.setIconImage(Toolkit.getDefaultToolkit().
                getImage("src/sortings/pi.png"));
        infoJTextArea1.setCaretPosition(0);
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleJLabel = new javax.swing.JLabel();
        closeJButton = new javax.swing.JButton();
        cityPictureJLabel = new javax.swing.JLabel();
        authorJLabel = new javax.swing.JLabel();
        versionJLabel = new javax.swing.JLabel();
        copyrightJLabel1 = new javax.swing.JLabel();
        dateJLabel = new javax.swing.JLabel();
        infoJScrollPane = new javax.swing.JScrollPane();
        infoJTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Famous Composers About");
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        titleJLabel.setFont(new java.awt.Font("Tempus Sans ITC", 2, 36)); // NOI18N
        titleJLabel.setForeground(new java.awt.Color(0, 102, 102));
        titleJLabel.setText("Searching and Sorting About Form");

        closeJButton.setBackground(new java.awt.Color(204, 255, 204));
        closeJButton.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        closeJButton.setMnemonic('C');
        closeJButton.setText("Close");
        closeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeJButtonActionPerformed(evt);
            }
        });

        cityPictureJLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Sortings/pi.png"))); // NOI18N

        authorJLabel.setText("Author:  Abylay Dospayev");

        versionJLabel.setText("Version 1.1.0");

        copyrightJLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        copyrightJLabel1.setText("Copyright: Freeware");

        dateJLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        dateJLabel.setText("Date:  10/14/2020");

        infoJTextArea1.setEditable(false);
        infoJTextArea1.setColumns(20);
        infoJTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        infoJTextArea1.setLineWrap(true);
        infoJTextArea1.setRows(5);
        infoJTextArea1.setText("This program does the following:\n\n1.  Displays the original array of integer--the size of the array can be a constant or user specified.\n2.  Searches linearly for the specified integer of the unsorted array, reporting the location (index in the array) where (and if) found and the number of comparisons performed.\n3.  A void method swap which exchanges any two members of the array (each call to this method counts as one exchange).\n4.  Sorts the array (save it initially and then copy it for each subsequent sorting) with five different algorithms (should be separate methods): bubble sort, insertion sort, selection sort, merge sort, and quick sort.\n5.  Searches with binary search the sorted array for the specified integer reporting the location (index of the array) where (and if) found.\n6.  All of the searching and sorting algorithms should be in a separate SortingAndSearchingAlgorithms class.");
        infoJTextArea1.setWrapStyleWord(true);
        infoJScrollPane.setViewportView(infoJTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(authorJLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(41, 41, 41))
                            .addComponent(versionJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(copyrightJLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateJLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(infoJScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(cityPictureJLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cityPictureJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(infoJScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(copyrightJLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateJLabel)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(authorJLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(versionJLabel)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(closeJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>
     * Method       closeJButtonActionPerformed
     * Description  Closes the About form only
     * Date         3/31/2020
     * History log  4/4/2016, 1/4/2019
     * @author      <i>Niko Culevski</i>
     * @param       evt java.awt.event.ActionEvent
     *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void closeJButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_closeJButtonActionPerformed
    {//GEN-HEADEREND:event_closeJButtonActionPerformed
        this.dispose();        
}//GEN-LAST:event_closeJButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorJLabel;
    private javax.swing.JLabel cityPictureJLabel;
    private javax.swing.JButton closeJButton;
    private javax.swing.JLabel copyrightJLabel1;
    private javax.swing.JLabel dateJLabel;
    private javax.swing.JScrollPane infoJScrollPane;
    private javax.swing.JTextArea infoJTextArea1;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JLabel versionJLabel;
    // End of variables declaration//GEN-END:variables

}
