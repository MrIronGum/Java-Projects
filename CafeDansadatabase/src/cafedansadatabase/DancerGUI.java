package cafedansadatabase;

import java.awt.Toolkit;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *<pre>
 * Class        DancerGUI.java
 * Project      Cafe Dansa Database
 * Description  A class representing the GUI used in a maintaining a cafe dance 
 *              database obtained from a text file, Cities.txt with 5 fields:
 *              name, dance preference style, proficiency, length in years of dancing,
 *              phone and email. Functionalities include:
 *              viewing of the data for selected dancer, add, delete, edit, sort
 *              by years and by name, and search for cpecified dancer.
 * File         CitiesGUI.java
 * Platform     jdk 1.8.0_214; NetBeans IDE 11.3; Windows 10
 * Course       CS 142, Edmonds Community College
 * Hours        12 hours and 45 minutes
 * Date         10/10/2020
 * History log  
 *
 * @author	<i>Abylay Dospayev</i>
 * @version 	1.0.0
 * @see     	javax.swing.JFrame
 * @see        java.awt.Toolkit
 * @see         java.util.ArrayList
 *</pre>
 *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
public class DancerGUI extends javax.swing.JFrame {
 //class instance ArrrayList of Dancer object
    private ArrayList<Dancer> dancers = new ArrayList<>();
    //external file from dancers
    private String fileName = "src\\cafedansadatabase\\Dancers.txt";
    
     /** Different styles of dance employed by the dancers. */
    public final static String[] STYLES = new String[]{"baladi", "balkan",
        "ballet", "ballroom", "bhangra", "firedancing", "irish step dancing", 
        "milonga", "modern pop", "rave", "salsa", "samba", "shuffle", "tap"};
    /** Different levels of proficiency held by the dancers. */
    public final static String[] PROFICIENCIES = new String[]{"beginner",
        "intermediate", "advanced", "expert", "master", "guru"};
    
 
    //private final String fileNameXML = "src/USACities/AltCities.xml"
    private final DecimalFormat number = new DecimalFormat("#,##0");
    private final DecimalFormat dollars = new DecimalFormat("$#,##0.00");
    public DancerGUI() {
        this.dancers = new ArrayList<>();
        //builts the form
        initComponents();
        //set buttonAdd as default
        this.getRootPane().setDefaultButton(addjButton);
        //set icon
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/cafedansadatabase/dancegroup1.jpg"));
        //centers the form at start
        setLocationRelativeTo(null);
        
        //Read from an external text file Dancers.txt and populate an Arraylist of Dancer type
        readFromFile(fileName);
        //Show the member list in the JList and display data for selected city
        displayDancers();
        int index = dancersjList.getSelectedIndex();
        if (index >= 0)
            showDancerData(dancersjList.getSelectedIndex());
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     * <pre>
     * Method       readFromFile
     * Description  Reads dancers from a text file that is comma delimited and
     *              creates an instance of the Dancer class with the data read.
     *              Then the newly created dancers is added to the dancers database.
     *              Uses an object from the ReadFile class to read record.
     * @author      <i>Abylay Dospayev</i>
     * Date         10/10/2022
     * History Log  
     * @param       file String
     * @see         java.util.Scanner
     *</pre>   
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void readFromFile(String file)
    {
        //clear the ArrayList
        dancers.clear();
        try
        {
            //Read while there is data
            Scanner input = new Scanner(new File(file));
            String line = "";
            //coryphee - the leading dancer
            Dancer coryphee  = null;
            StringTokenizer token = null;
            while(input.hasNextLine())
            {
                line = input.nextLine();
                coryphee = new Dancer();
                token = new StringTokenizer(line, ",");
                while (token.hasMoreElements())
                {
                    coryphee.setName(token.nextToken());
                    coryphee.setStyle(token.nextToken());
                    coryphee.setProficiency(token.nextToken());
                    coryphee.setYears(Integer.parseInt(token.nextToken()));
                    coryphee.setPhone(token.nextToken());
                    coryphee.setEmail(token.nextToken());
                 }
                //add dancer to ArrayList
                dancers.add(coryphee);
            }
            input.close();
        }
        catch(FileNotFoundException e) 
        {
            JOptionPane.showMessageDialog(null, file + " does not exist",
       "File input Error", JOptionPane.WARNING_MESSAGE);
            //Bring up JFileChooser to select file in current directory
            JFileChooser chooser = new JFileChooser("src/cafedansadatabase");
            //Filter only txt files 
            FileNameExtensionFilter filter = new FileNameExtensionFilter(
            "Txt Files", "txt");
            chooser.setFileFilter(filter);
            int choice = chooser.showOpenDialog(null);
            if (choice == JFileChooser.APPROVE_OPTION)
            {
                File chosenFile = chooser .getSelectedFile();
                file = "src/cafedansadatabase_abylay/" + chosenFile.getName();
                //System.out.println("file = " + file);
                readFromFile(file);
            }
            else //weird I/O error
            {
                JOptionPane.showMessageDialog(null, "Unable to read file",
                        "File Input Error", JOptionPane.WARNING_MESSAGE);
            }   
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Unable to read file", 
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }
        
        
        
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>>
     * Method       displayDancers()
     * Description  Displays dancers in JList sorted by level = 0 using 
     *              selection sort algorithm or last name = 1 using the 
     *              insertion sort algorithm.
     * @author      <i>Niko Culevski</i>
     * Date         4/4/2020
     * History Log  7/18/2018, 12/13/2019
     * @see         #selectionSort
     * @see         #insetionSort
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void displayDancers(){
        //get index of current dancer
        int location = dancersjList.getSelectedIndex(); 
        ///array with names only
        String[] dancersList = new String[dancers.size()];
        if(yearsjRadioButtonMenuItem.isSelected()){
            //sort by size using selection sort in descending order and display name of the dancer and years of dancing
            //sort by population using quick sort in descending order and display name of the dancer and years of dancing
            selectionSort(dancers);
            for(int index = 0; index < dancers.size(); index++)
            {
                dancersList[index] = dancers.get(index).getName()+", " 
                        +dancers.get(index).getYears()+" years. ";
            }
        }
        else //display dancers by name only
        {   
            //sort by dancer's name using insertion sort and display name only
            insertionSort(dancers);
            for(int index = 0; index < dancers.size(); index++)
            {
                dancersList[index] = dancers.get(index).getName();
            }
        }
        dancersjList.setListData(dancersList); //populate JList with dancersjList
        if(location < 0)
            dancersjList.setSelectedIndex(0);
        else
            dancersjList.setSelectedIndex(location);
    }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>>
     * Method       selectionSort
     * Description  Sorts ArrayList cities in descending order by years. 
     *              Calls findsMaximum to find dancers with maximum years in 
     *              each pass and swap to exchange dancers when necessary.
     * @param       dancers Dancer
     * @parem       cities ArrayList
     * @author      <i>Abylay Dospayev</i>
     * Date         10/10/2022
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public void selectionSort(ArrayList<Dancer> dancers)
     {
         int max = 0;
         for (int i=0; i < dancers.size(); i++)
         {
             max = findMaximum(dancers, i);
             //swap(cities, i, max)
             Dancer temp = dancers.get(i);
             dancers.set(i, dancers.get(max));
             dancers.set(max,temp);
         }
     }
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>>
     * Method       findMaximum
     * Description  Called by selectionSort to find the index of the member 
     *              with the maximum years in dancing from a given index to the end 
     *              of the ArrayList
     * @param       dancers Dancer
     * @param       i int
     * @return      max int
     * @parem       cities ArrayList
     * @parem       int i: index from which to search for the max >= 0
     * @author      <i>Abylay Dospayev</i>
     * Date         4/4/2020
     * History Log  7/18/2018, 12/13/2019
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
     public int findMaximum(ArrayList<Dancer> dancers, int i)
     {
         int j, max = i;
         for (j= i + 1; j < dancers.size(); j++)
         {
             if (dancers.get(j).getYears() > dancers.get(max).getYears())
                 max = j;
         }
         return max;
     }

     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>>
     * Method       insertionSort
     * Description  Sorts ArrayList cities in ascending order by name. Uses 
     *              the insertion sort algorithm which inserts dancer at correct 
     *              position and shuffles everyone else below that position.
     * @param       dancers Dancer
     * @parem       cities ArrayList
     * @author      <i>Abylay Dospayev</i>
     * Date         10/10/2022
     * History Log  
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
     public static void insertionSort(ArrayList<Dancer> dancers)
     {
         int i,j;
         for (i = 0; i < dancers.size(); i++)
         {
             Dancer temp = dancers.get(i);
             j = i - 1;
             while (j >= 0 && dancers.get(j).getName().compareToIgnoreCase(temp.getName())>0)
             {
                 dancers.set(j+1, dancers.get(j));
                 j--;
             }
             dancers.set(j+1, temp);
         }
     }
     
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>>
     * Method       showDancerData()
     * Description  Display information about selected dancer 
     * @param       index int 
     * @author      <i>Niko Culevski</i>
     * Date         4/4/2020
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
     private void showDancerData(int index)
     {
        if (index >= 0 && index < dancers.size())
        {
            namejTextField.setText(dancers.get(index).getName());
        stylejTextField.setText(dancers.get(index).getStyle());
        leveljTextField.setText(dancers.get(index).getProficiency());
        yearsjTextField.setText(String.valueOf(dancers.get(index).getYears())
                + " years");
        phonejTextField.setText(dancers.get(index).getPhone());
        emailjTextField.setText(dancers.get(index).getEmail());
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

        titlejPanel = new javax.swing.JPanel();
        imagefirstjLabel = new javax.swing.JLabel();
        imagesecondjLabel = new javax.swing.JLabel();
        titlejLabel = new javax.swing.JLabel();
        listjPanel = new javax.swing.JPanel();
        listjScrollPane = new javax.swing.JScrollPane();
        dancersjList = new javax.swing.JList<>();
        displayjPanel = new javax.swing.JPanel();
        namejLabel = new javax.swing.JLabel();
        namejTextField = new javax.swing.JTextField();
        stylejLabel = new javax.swing.JLabel();
        stylejTextField = new javax.swing.JTextField();
        leveljLabel = new javax.swing.JLabel();
        leveljTextField = new javax.swing.JTextField();
        yearsjLabel = new javax.swing.JLabel();
        yearsjTextField = new javax.swing.JTextField();
        phonejLabel = new javax.swing.JLabel();
        phonejTextField = new javax.swing.JTextField();
        emailjLabel = new javax.swing.JLabel();
        emailjTextField = new javax.swing.JTextField();
        controljPanel = new javax.swing.JPanel();
        addjButton = new javax.swing.JButton();
        editjButton = new javax.swing.JButton();
        deletejButton = new javax.swing.JButton();
        exitjButton = new javax.swing.JButton();
        dancersjMenuBar = new javax.swing.JMenuBar();
        filejMenu = new javax.swing.JMenu();
        newjMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        printjMenuItem = new javax.swing.JMenuItem();
        printdancerjMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        saveJMenuItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        exitjMenuItem = new javax.swing.JMenuItem();
        sortingjMenu = new javax.swing.JMenu();
        namejRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        yearsjRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        dancerdatabasejMenu = new javax.swing.JMenu();
        addjMenuItem = new javax.swing.JMenuItem();
        editjMenuItem = new javax.swing.JMenuItem();
        deletejMenuItem = new javax.swing.JMenuItem();
        searchjMenuItem = new javax.swing.JMenuItem();
        detailsjMenuItem = new javax.swing.JMenuItem();
        helpjMenu = new javax.swing.JMenu();
        aboutjMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        imagefirstjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafedansadatabase/dancegroup2.jpg"))); // NOI18N

        imagesecondjLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cafedansadatabase/dancegroup1.jpg"))); // NOI18N

        titlejLabel.setFont(new java.awt.Font("Tahoma", 2, 30)); // NOI18N
        titlejLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlejLabel.setText("Cafè Dansa Database");

        javax.swing.GroupLayout titlejPanelLayout = new javax.swing.GroupLayout(titlejPanel);
        titlejPanel.setLayout(titlejPanelLayout);
        titlejPanelLayout.setHorizontalGroup(
            titlejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlejPanelLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(imagesecondjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(titlejLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(imagefirstjLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        titlejPanelLayout.setVerticalGroup(
            titlejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titlejPanelLayout.createSequentialGroup()
                .addGroup(titlejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagefirstjLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(titlejPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(titlejPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titlejLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(imagesecondjLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );

        dancersjList.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        dancersjList.setFixedCellWidth(250);
        dancersjList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                dancersjListValueChanged(evt);
            }
        });
        listjScrollPane.setViewportView(dancersjList);

        javax.swing.GroupLayout listjPanelLayout = new javax.swing.GroupLayout(listjPanel);
        listjPanel.setLayout(listjPanelLayout);
        listjPanelLayout.setHorizontalGroup(
            listjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listjPanelLayout.createSequentialGroup()
                .addComponent(listjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        listjPanelLayout.setVerticalGroup(
            listjPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listjPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(listjScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        displayjPanel.setLayout(new java.awt.GridLayout(6, 2, 5, 5));

        namejLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        namejLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        namejLabel.setText("Name of Dancer:");
        namejLabel.setToolTipText("");
        displayjPanel.add(namejLabel);

        namejTextField.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        namejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namejTextFieldActionPerformed(evt);
            }
        });
        displayjPanel.add(namejTextField);

        stylejLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        stylejLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        stylejLabel.setText("Dance Style:");
        stylejLabel.setToolTipText("");
        displayjPanel.add(stylejLabel);

        stylejTextField.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        stylejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stylejTextFieldActionPerformed(evt);
            }
        });
        displayjPanel.add(stylejTextField);

        leveljLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        leveljLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        leveljLabel.setText("Level of Proficiency:");
        leveljLabel.setToolTipText("");
        displayjPanel.add(leveljLabel);

        leveljTextField.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        leveljTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leveljTextFieldActionPerformed(evt);
            }
        });
        displayjPanel.add(leveljTextField);

        yearsjLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        yearsjLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        yearsjLabel.setText("Years of Dancing:");
        yearsjLabel.setToolTipText("");
        displayjPanel.add(yearsjLabel);

        yearsjTextField.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        yearsjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearsjTextFieldActionPerformed(evt);
            }
        });
        displayjPanel.add(yearsjTextField);

        phonejLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        phonejLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        phonejLabel.setText("Phone:");
        phonejLabel.setToolTipText("");
        displayjPanel.add(phonejLabel);

        phonejTextField.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        phonejTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonejTextFieldActionPerformed(evt);
            }
        });
        displayjPanel.add(phonejTextField);

        emailjLabel.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        emailjLabel.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        emailjLabel.setText("Email:");
        emailjLabel.setToolTipText("");
        displayjPanel.add(emailjLabel);

        emailjTextField.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        emailjTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailjTextFieldActionPerformed(evt);
            }
        });
        displayjPanel.add(emailjTextField);

        controljPanel.setLayout(new java.awt.GridLayout(1, 5, 5, 5));

        addjButton.setBackground(new java.awt.Color(255, 204, 204));
        addjButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        addjButton.setText("Add");
        addjButton.setToolTipText("Add dancer");
        addjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjButtonActionPerformed(evt);
            }
        });
        controljPanel.add(addjButton);

        editjButton.setBackground(new java.awt.Color(255, 204, 204));
        editjButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        editjButton.setText("Edit");
        editjButton.setToolTipText("Edit dancer");
        editjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editjButtonActionPerformed(evt);
            }
        });
        controljPanel.add(editjButton);

        deletejButton.setBackground(new java.awt.Color(255, 204, 204));
        deletejButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        deletejButton.setText("Delete");
        deletejButton.setToolTipText("Delete dancer");
        deletejButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejButtonActionPerformed(evt);
            }
        });
        controljPanel.add(deletejButton);

        exitjButton.setBackground(new java.awt.Color(255, 204, 204));
        exitjButton.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        exitjButton.setText("Exit");
        exitjButton.setToolTipText("Exit");
        exitjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitjButtonActionPerformed(evt);
            }
        });
        controljPanel.add(exitjButton);

        filejMenu.setText("File");
        filejMenu.setToolTipText("File");

        newjMenuItem.setText("New");
        newjMenuItem.setToolTipText("Open database of dancers");
        newjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newjMenuItemActionPerformed(evt);
            }
        });
        filejMenu.add(newjMenuItem);
        filejMenu.add(jSeparator1);

        printjMenuItem.setText("Print Form");
        printjMenuItem.setToolTipText("Prints whole page as an image");
        printjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printjMenuItemActionPerformed(evt);
            }
        });
        filejMenu.add(printjMenuItem);

        printdancerjMenuItem.setText("Print Dancer");
        printdancerjMenuItem.setToolTipText("Prints detail of the dancer");
        printdancerjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printdancerjMenuItemActionPerformed(evt);
            }
        });
        filejMenu.add(printdancerjMenuItem);
        filejMenu.add(jSeparator2);

        saveJMenuItem.setText("Save");
        saveJMenuItem.setToolTipText("Save ");
        filejMenu.add(saveJMenuItem);
        filejMenu.add(jSeparator3);

        exitjMenuItem.setText("Exit");
        exitjMenuItem.setToolTipText("Exit");
        filejMenu.add(exitjMenuItem);

        dancersjMenuBar.add(filejMenu);

        sortingjMenu.setText("Sort");
        sortingjMenu.setToolTipText("Sorting");

        namejRadioButtonMenuItem.setSelected(true);
        namejRadioButtonMenuItem.setText("By name");
        namejRadioButtonMenuItem.setToolTipText("Sorting by name");
        namejRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namejRadioButtonMenuItemActionPerformed(evt);
            }
        });
        sortingjMenu.add(namejRadioButtonMenuItem);

        yearsjRadioButtonMenuItem.setSelected(true);
        yearsjRadioButtonMenuItem.setText("By years");
        yearsjRadioButtonMenuItem.setToolTipText("Sorting by years");
        yearsjRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearsjRadioButtonMenuItemActionPerformed(evt);
            }
        });
        sortingjMenu.add(yearsjRadioButtonMenuItem);

        dancersjMenuBar.add(sortingjMenu);

        dancerdatabasejMenu.setText("Dancer Database");

        addjMenuItem.setText("Add");
        addjMenuItem.setToolTipText("Add dancer");
        addjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addjMenuItemActionPerformed(evt);
            }
        });
        dancerdatabasejMenu.add(addjMenuItem);

        editjMenuItem.setText("Edit");
        editjMenuItem.setToolTipText("Edit dancer");
        editjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editjMenuItemActionPerformed(evt);
            }
        });
        dancerdatabasejMenu.add(editjMenuItem);

        deletejMenuItem.setText("Delete");
        deletejMenuItem.setToolTipText("Delete dancer");
        deletejMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletejMenuItemActionPerformed(evt);
            }
        });
        dancerdatabasejMenu.add(deletejMenuItem);

        searchjMenuItem.setText("Search");
        searchjMenuItem.setToolTipText("Search dancer");
        searchjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchjMenuItemActionPerformed(evt);
            }
        });
        dancerdatabasejMenu.add(searchjMenuItem);

        detailsjMenuItem.setText("Details");
        detailsjMenuItem.setToolTipText("Look up the details");
        dancerdatabasejMenu.add(detailsjMenuItem);

        dancersjMenuBar.add(dancerdatabasejMenu);

        helpjMenu.setText("Help");

        aboutjMenuItem.setText("About");
        aboutjMenuItem.setToolTipText("About form");
        aboutjMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutjMenuItemActionPerformed(evt);
            }
        });
        helpjMenu.add(aboutjMenuItem);

        dancersjMenuBar.add(helpjMenu);

        setJMenuBar(dancersjMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titlejPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(controljPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(displayjPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(titlejPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(listjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(displayjPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(controljPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        newJMenuItemActionPerformed()
    * Description   Show a JFileChooser with an OpenDialog to detect a
    *               different dancer database
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void newjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newjMenuItemActionPerformed
        JFileChooser chooser = new JFileChooser("src/cafedansadatabase");
        // Filter only txt files
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Txt Files", "txt");
        chooser.setFileFilter(filter);
        int choice = chooser.showOpenDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION)
        {
            //Clear existing cities ArrayList and JList 
            dancers.clear();
            dancersjList.removeAll();
            File chosenFile = chooser.getSelectedFile();
            String file = "src/cafedansadatabase/" + chosenFile.getName();
            
            //need to update fileName to save changes in correct file--cannot be final 
            fileName = file;

            readFromFile(file);
            displayDancers();
        }
        else //weird error
        {
            JOptionPane.showMessageDialog(null, "Unable to read file",
                    "File Input Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_newjMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        addJMenuItemActionPerformed()
    * Description   Event Handler for addJMenuItem to invoke the 
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void addjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addjMenuItemActionPerformed
        addjButtonActionPerformed(evt);
    }//GEN-LAST:event_addjMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        aboutJMenuItemActionPerformed()
    * Description   Event Handler for aboutJMenuItemActionPerformed to show About form
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void aboutjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutjMenuItemActionPerformed
        //Display About form
        About aboutWindow = new About(this, true);
        aboutWindow.setVisible(true);
    }//GEN-LAST:event_aboutjMenuItemActionPerformed

    private void namejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namejTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namejTextFieldActionPerformed

    private void stylejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stylejTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stylejTextFieldActionPerformed

    private void leveljTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leveljTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leveljTextFieldActionPerformed

    private void yearsjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearsjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearsjTextFieldActionPerformed

    private void phonejTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonejTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonejTextFieldActionPerformed

    private void emailjTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailjTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailjTextFieldActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>>
     * Method       dancersjListValueChanged()
     * Description  Event handler for dancersjListValueChanged to update information
     *              on selected dancer
     * @param       evt ListSelectionEvent
     * @author      <i>Abylay Dospayev</i>
     * Date         10/10/2022
     * History Log  
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void dancersjListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_dancersjListValueChanged
        int index = (dancersjList.getSelectedIndex());
        if (index >= 0)
            showDancerData(index);
    }//GEN-LAST:event_dancersjListValueChanged
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>>
     * Method       namejRadioButtonMenuItemActionPerformed()
     * Description  Event handler for namejRadioButtonMenuItemActionPerformed to display dancers
     *              on selected city
     * @param       evt ActionEvent
     * @author      <i>Abylay Dospayev</i>
     * Date         10/10/2022
     * History Log  
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void namejRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namejRadioButtonMenuItemActionPerformed
        displayDancers();
    }//GEN-LAST:event_namejRadioButtonMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
     *<pre>>
     * Method       yearsjRadioButtonMenuItemActionPerformed()
     * Description  Event handler for namejRadioButtonMenuItemActionPerformed to display dancers
     *              on selected city
     * @param       evt ActionEvent
     * @author      <i>Abylay Dospayev</i>
     * Date         10/10/2022
     * History Log  
     * </pre>
     *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/ 
    private void yearsjRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearsjRadioButtonMenuItemActionPerformed
        displayDancers();
    }//GEN-LAST:event_yearsjRadioButtonMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        printJMenuItemActionPerformed()
    * Description   Event Handler for printJMenuItem to print the form as a GUI
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printjMenuItemActionPerformed
        PrintUtilities.printComponent(this);
    }//GEN-LAST:event_printjMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        printdancerjMenuItemActionPerformed()
    * Description   Event Handler for Printing the Details about the Dancer
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void printdancerjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printdancerjMenuItemActionPerformed
        // Print selected dancer
        int index = dancersjList.getSelectedIndex();
        JTextArea printDancer = new JTextArea();
        if(index >= 0)
        {
            try 
            {
                Dancer temp = new Dancer(dancers.get(index));
                String output = "Name of the Dancer: " + temp.getName() + "\n" + 
                        "Dance Style: " + temp.getStyle() + " \n" +
                        "Level of Proficiency: " + temp.getProficiency()+"\n" +
                        "Years of Dancing: " + temp.getYears() + " years\n" +
                        "Phone number: " + temp.getPhone() + "\n"
                        + "Email: " + temp.getEmail();
               printDancer.setText(output);
               printDancer.print();
            }
            catch(PrinterException ex)
            {
                JOptionPane.showMessageDialog(null, "City not Printed",
                        "Print Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_printdancerjMenuItemActionPerformed
       /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        exitJButtonActionPerformed()
    * Description   Event handler to close the application
    * @param        evt ActionWvent
    * @see          java.awt.event.ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          4/4/2020
    * History Log   7/18/2018, 12/13/2019
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void exitjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitjButtonActionPerformed
         System.exit(0);
    }//GEN-LAST:event_exitjButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        deleteJMenuItemActionPerformed
    * Description   Event Handler for addMenuItem to invoke to deleteJMenuItem
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void deletejMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejMenuItemActionPerformed
        deletejButtonActionPerformed(evt);
    }//GEN-LAST:event_deletejMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        deleteJButtonActionPerformed()
    * Description   Event Handler for deleteJButton to delete selcted dancer
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          10/10/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void deletejButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletejButtonActionPerformed
        int index = dancersjList.getSelectedIndex();
        String name = dancers.get(index).getName();
        int result = JOptionPane.showConfirmDialog(null, 
                "Are you sure you wish to delete " + name + "?", "Delete dancer",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        if (result == JOptionPane.YES_OPTION)   //confirm delete selected city
        {
            index = dancersjList.getSelectedIndex();
            dancers.remove(index);
            displayDancers();
            saveDancers(fileName);
        }
    }//GEN-LAST:event_deletejButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        searchjMenuItemActionPerformed()
    * Description   Event Handler for searchJMenuItem
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void searchjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchjMenuItemActionPerformed
        String dancerName = JOptionPane.showInputDialog("Enter name of dancer");
        searchDancer(dancerName);
    }//GEN-LAST:event_searchjMenuItemActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        addJButtonActionPerformed()
    * Description   Event Handler for adding a city by invoking the AddCity
    *               form.No empty or duplicate city is added.The new city 
    *               is added to the JList and saved in the Cities.txt file
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void addjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addjButtonActionPerformed
        try
        {
            //Create and display a new AddDialog
            AddDancer addCity = new AddDancer(this, true);
            addCity.setVisible(true);//the modal dialog takes focus, upon regainig focus:
            Dancer newDancer;
            newDancer = addCity.getDancer();
            if(newDancer != null && !dancerExists(newDancer))
            {
                //Add the new city to database
                dancers.add(addCity.getDancer());
                displayDancers();
                searchDancer(newDancer.getName());
                
                //save new city to file
                saveDancers(fileName);
            }
            else
            {
                dancersjList.setVisible(true);
                dancersjList.setSelectedIndex(0);
            }
        }
        catch (NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null, "Dancer not Added", 
                    "Added Dancer Error", JOptionPane.WARNING_MESSAGE);
            dancersjList.setVisible(true);
            dancersjList.setSelectedIndex(0);
            
         
        }
    }//GEN-LAST:event_addjButtonActionPerformed
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        editJMenuItemActionPerformed()
    * Description   Event Handler for editJButtonActionPerformed to edit city
    * @param        evt ActionEvent
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void editjMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editjMenuItemActionPerformed
        editjButton.doClick();
    }//GEN-LAST:event_editjMenuItemActionPerformed

    private void editjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editjButtonActionPerformed
        try
        {
            String cityName = dancersjList.getSelectedValue().toString();
            if(cityName.contains(","))
        
                cityName= cityName.substring(0, cityName.indexOf(','));
            Dancer dancerToEdit = new Dancer(findDancer(cityName));
            int index = dancersjList.getSelectedIndex();
            EditDancer editedDancer = new EditDancer(dancerToEdit);
            editedDancer.setVisible(true);
            if (editedDancer.getDancer() != null)
            {
                dancers.remove(index);
                dancers.add(editedDancer.getDancer());
                saveDancers(fileName);
                displayDancers();
            }
        }
        
        catch(NullPointerException nullex)
        {
            JOptionPane.showMessageDialog(null,"Dancer not Edited","Edit Dancer Error", 
                    JOptionPane.WARNING_MESSAGE);
            dancersjList.setVisible(true);
            dancersjList.setSelectedIndex(0);
        }
    }//GEN-LAST:event_editjButtonActionPerformed

  /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        findDancer()
    * Description   Search for a Dancer by name and highlight if found 
    * @param        dancerName String
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private Dancer findDancer(String dancerName)
    {
        int index = -1;
        namejRadioButtonMenuItem.doClick();
        for (int i = 0; i < dancers.size(); i++)
        {
            if (dancerName.equals(dancers.get(i).getName()))
                index = i;
        }
        if (index >= 0 )
        {
            dancersjList.setSelectedIndex(index);
            return dancers.get(index);
        }
        else
            return null;
    }
        
    
    /**
    * <pre>
    * Method       DancerExists()
    * Description  Boolean method to determine if a dancer to be added exists
    * @return      thereIsOne
    * @param       coryphee Dancer
    * @author      Abylay Dospayev
    * Date         9/24/2022
    * </pre> 
    */
    private boolean dancerExists(Dancer coryphee)
    {
        boolean thereIsOne = false;
        for(int index = 0; index < dancers.size() && !thereIsOne; index++)
        {
            if (dancers.get(index).equals(coryphee))
            thereIsOne = true;
        }
        return thereIsOne;
    }
    
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        searchDancer
    * Description   Search for a dancer by name and highlight if found 
    * @param        dancerName String
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void searchDancer(String dancerName)
    {
        if ((dancerName != null) && (dancerName.length()>0))
        {
            //Sort the JList of city name by name 
            namejRadioButtonMenuItem.setSelected(true);
            displayDancers();
            
            //Create a String array of city names
            String[] cityArray = new String[dancers.size()];
            for (int i = 0; i < cityArray.length; i++)
                cityArray[i] = dancers.get(i).getName().toLowerCase();
            //Find index of city
            //int index = binarySearch(cityArray, cityName.toLowerCase());
            int index = linearSearch(cityArray, dancerName.toLowerCase());
            if (index < 0)
            {
                JOptionPane.showMessageDialog(null, "Dancer " + dancerName + 
                        " not Found", "Search Result", JOptionPane.WARNING_MESSAGE);
                dancersjList.setSelectedIndex(0);
            }
            else 
                dancersjList.setSelectedIndex(index);
        }
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        linearSearch()
    * Description   Event handler to search dancer by name using the linear 
    *               search algorithm and to display its index if found and -1 if not found
    * @return       index int
    * @param        dancerArray String[]
    * @param        dancerName String
    * @author       <i>Abylay Dospayev</i>
    * Date          10/10/2022
    * History Log      
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private int linearSearch(String[] dancerArray, String dancerName)
    {
        int index = -1;
        boolean found = false;
        for (int i = 0; i < dancerArray.length && !found; i++)
        {
            if(dancerArray[i].toLowerCase().contains(dancerName.toLowerCase()))
            {
                index = i;
                found = true;
            }
        }
        return index;
    }
     /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    *<pre>
    * Method        saveDancers()
    * Description   Write dancers to a text file that is comma delimited
    * @param        file String
    * @author       <i>Abylay Dospayev</i>
    * Date          9/28/2022
    * History Log      
    * @see          java.io.FileWriter
    * @see          java.io.PrintWrite
    * @see          Dancer
    *</pre>
    *~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    private void saveDancers(String file)
    {
        
        try 
        {   
            FileWriter filePointer = new FileWriter(file, false);
            PrintWriter output = new PrintWriter(filePointer);
            for(int index = 0; index < dancers.size(); index++)
            {
                Dancer tempDancer = dancers.get(index);
                String line = tempDancer.getName() + "," + 
                        tempDancer.getStyle()+ "," + tempDancer.getProficiency() +
                        "," + tempDancer.getYears() + "," + tempDancer.getPhone()+","+tempDancer.getEmail();
            // do not add an extra blank line to end of file
            if (index == dancers.size()-1)
                output.write(line);
            else 
                output.write(line + "\n");
            }
            output.close();
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Dancer not Saved", "Save Error",
                    JOptionPane.WARNING_MESSAGE);
            dancersjList.setVisible(true);
            dancersjList.setSelectedIndex(0);
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DancerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DancerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DancerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DancerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        Splash mySplash = new Splash(2600);
        mySplash.showSplash();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DancerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutjMenuItem;
    private javax.swing.JButton addjButton;
    private javax.swing.JMenuItem addjMenuItem;
    private javax.swing.JPanel controljPanel;
    private javax.swing.JMenu dancerdatabasejMenu;
    private javax.swing.JList<String> dancersjList;
    private javax.swing.JMenuBar dancersjMenuBar;
    private javax.swing.JButton deletejButton;
    private javax.swing.JMenuItem deletejMenuItem;
    private javax.swing.JMenuItem detailsjMenuItem;
    private javax.swing.JPanel displayjPanel;
    private javax.swing.JButton editjButton;
    private javax.swing.JMenuItem editjMenuItem;
    private javax.swing.JLabel emailjLabel;
    private javax.swing.JTextField emailjTextField;
    private javax.swing.JButton exitjButton;
    private javax.swing.JMenuItem exitjMenuItem;
    private javax.swing.JMenu filejMenu;
    private javax.swing.JMenu helpjMenu;
    private javax.swing.JLabel imagefirstjLabel;
    private javax.swing.JLabel imagesecondjLabel;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JLabel leveljLabel;
    private javax.swing.JTextField leveljTextField;
    private javax.swing.JPanel listjPanel;
    private javax.swing.JScrollPane listjScrollPane;
    private javax.swing.JLabel namejLabel;
    private javax.swing.JRadioButtonMenuItem namejRadioButtonMenuItem;
    private javax.swing.JTextField namejTextField;
    private javax.swing.JMenuItem newjMenuItem;
    private javax.swing.JLabel phonejLabel;
    private javax.swing.JTextField phonejTextField;
    private javax.swing.JMenuItem printdancerjMenuItem;
    private javax.swing.JMenuItem printjMenuItem;
    private javax.swing.JMenuItem saveJMenuItem;
    private javax.swing.JMenuItem searchjMenuItem;
    private javax.swing.JMenu sortingjMenu;
    private javax.swing.JLabel stylejLabel;
    private javax.swing.JTextField stylejTextField;
    private javax.swing.JLabel titlejLabel;
    private javax.swing.JPanel titlejPanel;
    private javax.swing.JLabel yearsjLabel;
    private javax.swing.JRadioButtonMenuItem yearsjRadioButtonMenuItem;
    private javax.swing.JTextField yearsjTextField;
    // End of variables declaration//GEN-END:variables
}
