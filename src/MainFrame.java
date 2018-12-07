
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class MainFrame extends javax.swing.JFrame {
    private Browser browser = new Browser();
    private BrowserView browserView = new BrowserView(browser);
    ImageIcon img = new ImageIcon("./src/icon.png");
    Timer m_timer = new Timer();
    DB_CONN DBM = new DB_CONN();
    
    public MainFrame() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Chart System");
        setVisible(true);
        setResizable(true);
        setSize(1300,760 );  
        setLocationRelativeTo(null);
        setIconImage(img.getImage());
        Panel_Chart.setComponentZOrder(DateChooserTo, 0);
        Panel_Chart.setComponentZOrder(DateChooserFrom, 1);
        Panel_Chart.setComponentZOrder(Panel_Chart_layer, 2);
        
        try {
            DBM.strURL += "Data_db";
            DBM.dbOpen();
            //DBM.dbClose();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
        
        browser.addLoadListener(new LoadAdapter(){
            @Override
            public void onFinishLoadingFrame(FinishLoadingEvent event){
               if (event.isMainFrame()) {
                   System.out.println("HTML 문서가 로드되었습니다.");
               }
            }
        });
        
        TimerTask m_task = new TimerTask(){
            @Override
            public void run() {
                String SQL = "call pro_select_now()";
                try {
                    DBM.DB_rs = DBM.DB_stmt.executeQuery(SQL);
                    while(DBM.DB_rs.next()){
                        if (DBM.DB_rs.getString("chk").equals("1")){
                            txtTem.setText(DBM.DB_rs.getString("tem") + " ℃");
                            txtHum.setText(DBM.DB_rs.getString("hum") + " %");
                        } else {
                            txtTem.setText("N / A");
                            txtHum.setText("N / A");
                        }
                    }
                    System.out.println("Main refreshed");
                } catch (SQLException ex) {
                    txtTem.setText("N / A");
                    txtHum.setText("N / A");
                    System.out.println("SQLException : " + ex.getMessage());
                }
            }
        };
        
        DateTime();
        m_timer.schedule(m_task, 0, 60000);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jButton1 = new javax.swing.JButton();
        TabbedPane1 = new javax.swing.JTabbedPane();
        Panel_Main = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtHum = new javax.swing.JTextField();
        Panel_Chart = new javax.swing.JPanel();
        Panel_Chart_layer = new javax.swing.JPanel();
        btnDraw = new javax.swing.JButton();
        lblFrom = new javax.swing.JLabel();
        DateChooserFrom = new com.toedter.calendar.JDateChooser();
        lblTo = new javax.swing.JLabel();
        DateChooserTo = new com.toedter.calendar.JDateChooser();
        TimeHourFrom = new javax.swing.JSpinner();
        lblFromHour = new javax.swing.JLabel();
        TimeHourTo = new javax.swing.JSpinner();
        lblToHour = new javax.swing.JLabel();
        TimeMinuteFrom = new javax.swing.JSpinner();
        TimeMinuteTo = new javax.swing.JSpinner();
        lblFromMinute = new javax.swing.JLabel();
        lblToMinute = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1280, 720));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        TabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        TabbedPane1.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        TabbedPane1.setMinimumSize(new java.awt.Dimension(1280, 691));
        TabbedPane1.setPreferredSize(new java.awt.Dimension(1280, 691));

        Panel_Main.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Main.setPreferredSize(new java.awt.Dimension(1000, 700));

        jLabel1.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel1.setText("현재 온도");

        txtTem.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N

        jLabel2.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N
        jLabel2.setText("현재 습도");

        txtHum.setFont(new java.awt.Font("굴림", 1, 24)); // NOI18N

        javax.swing.GroupLayout Panel_MainLayout = new javax.swing.GroupLayout(Panel_Main);
        Panel_Main.setLayout(Panel_MainLayout);
        Panel_MainLayout.setHorizontalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MainLayout.createSequentialGroup()
                .addGap(0, 276, Short.MAX_VALUE)
                .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtTem, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtHum, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(383, 383, 383))
        );
        Panel_MainLayout.setVerticalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_MainLayout.createSequentialGroup()
                .addGap(207, 207, 207)
                .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(367, Short.MAX_VALUE))
        );

        TabbedPane1.addTab("Main", Panel_Main);

        Panel_Chart.setBackground(new java.awt.Color(255, 255, 255));

        Panel_Chart_layer.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Chart_layer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("굴림", 1, 18))); // NOI18N
        Panel_Chart_layer.setMinimumSize(new java.awt.Dimension(1251, 0));
        Panel_Chart_layer.setName(""); // NOI18N
        Panel_Chart_layer.setPreferredSize(new java.awt.Dimension(1251, 558));

        javax.swing.GroupLayout Panel_Chart_layerLayout = new javax.swing.GroupLayout(Panel_Chart_layer);
        Panel_Chart_layer.setLayout(Panel_Chart_layerLayout);
        Panel_Chart_layerLayout.setHorizontalGroup(
            Panel_Chart_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Panel_Chart_layerLayout.setVerticalGroup(
            Panel_Chart_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );

        btnDraw.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnDraw.setText("Draw");
        btnDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawActionPerformed(evt);
            }
        });

        lblFrom.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        lblFrom.setText("From");

        DateChooserFrom.setBackground(new java.awt.Color(255, 255, 255));
        DateChooserFrom.setDateFormatString("yyyy. MM. dd");
        DateChooserFrom.setDoubleBuffered(false);
        DateChooserFrom.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N

        lblTo.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        lblTo.setText("To");

        DateChooserTo.setBackground(new java.awt.Color(255, 255, 255));
        DateChooserTo.setDateFormatString("yyyy. MM. dd");
        DateChooserTo.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N

        TimeHourFrom.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        TimeHourFrom.setModel(new javax.swing.SpinnerNumberModel(0, -1, 24, 1));
        TimeHourFrom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TimeHourFromStateChanged(evt);
            }
        });

        lblFromHour.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        lblFromHour.setText("시");

        TimeHourTo.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        TimeHourTo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 23, 1));
        TimeHourTo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TimeHourToStateChanged(evt);
            }
        });

        lblToHour.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        lblToHour.setText("시");

        TimeMinuteFrom.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        TimeMinuteFrom.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        TimeMinuteFrom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TimeMinuteFromStateChanged(evt);
            }
        });

        TimeMinuteTo.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        TimeMinuteTo.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        TimeMinuteTo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TimeMinuteToStateChanged(evt);
            }
        });

        lblFromMinute.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        lblFromMinute.setText("분");

        lblToMinute.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        lblToMinute.setText("분");

        jButton2.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        jButton2.setText("Export");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_ChartLayout = new javax.swing.GroupLayout(Panel_Chart);
        Panel_Chart.setLayout(Panel_ChartLayout);
        Panel_ChartLayout.setHorizontalGroup(
            Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ChartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                        .addComponent(Panel_Chart_layer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                                        .addComponent(DateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimeHourTo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblFrom))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimeHourFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                                        .addComponent(lblToHour)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimeMinuteTo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblToMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnDraw, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                                        .addComponent(lblFromHour)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimeMinuteFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblFromMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addComponent(jButton2))))))
                            .addComponent(lblTo))
                        .addGap(191, 825, Short.MAX_VALUE))))
        );
        Panel_ChartLayout.setVerticalGroup(
            Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ChartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TimeHourFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFromHour)
                                .addComponent(TimeMinuteFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFromMinute))
                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                .addComponent(lblFrom)
                                .addGap(2, 2, 2)
                                .addComponent(DateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addComponent(lblTo))
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimeHourTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblToHour)
                        .addComponent(TimeMinuteTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblToMinute)
                        .addComponent(btnDraw))
                    .addComponent(DateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_Chart_layer, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabbedPane1.addTab("Chart", Panel_Chart);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DateTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String datetime1 = dtf.format(now.minusHours(1));
        String datetime2 = dtf.format(now);
        Date date1 = null;
        Date date2 = null;
        int hour1 = Integer.parseInt(datetime1.substring(11,13));
        int hour2 = Integer.parseInt(datetime2.substring(11,13));
        int minute1 = Integer.parseInt(datetime1.substring(14,16));
        int minute2 = Integer.parseInt(datetime2.substring(14,16));
        try {
            date1 = new SimpleDateFormat("yyyy.MM.dd").parse(datetime1);
            date2 = new SimpleDateFormat("yyyy.MM.dd").parse(datetime2);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }
        DateChooserFrom.setDate(date1);
        TimeHourFrom.setValue(hour1);
        TimeMinuteFrom.setValue(minute1);
        DateChooserTo.setDate(date2);
        TimeHourTo.setValue(hour2);
        TimeMinuteTo.setValue(minute2);
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //this.dispose();
        
        //System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            DBM.dbClose();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawActionPerformed
        String title = "title";
        ArrayList<ChartElement> list = new ArrayList<ChartElement>();
        int width = 1220;
        int height = 400;
        String From = "";
        String To = "";

        String SQL = "call pro_select_DHT(";     
        SimpleDateFormat getDate = new SimpleDateFormat("yyyyMMdd");
        From = getDate.format(DateChooserFrom.getDate());
        if(String.valueOf(TimeHourFrom.getValue()).length() < 2)
            From += "0";
        From += TimeHourFrom.getValue();
        if(String.valueOf(TimeMinuteFrom.getValue()).length() < 2)
            From += "0";
        From += TimeMinuteFrom.getValue();
        From += "00";
        SQL += From + ", ";
        To = getDate.format(DateChooserTo.getDate());
        if(String.valueOf(TimeHourTo.getValue()).length() < 2)
            To += "0";
        To += TimeHourTo.getValue();
        if(String.valueOf(TimeMinuteTo.getValue()).length() < 2)
            To += "0";
        To += TimeMinuteTo.getValue();
        To += "59";
        SQL += To + ")";
        
        try {
            DBM.DB_rs = DBM.DB_stmt.executeQuery(SQL);
            while(DBM.DB_rs.next()){
                list.add(new ChartElement(DBM.DB_rs.getString("datetime"), DBM.DB_rs.getInt("tem"), DBM.DB_rs.getInt("hum")));
            }
        DBM.DB_rs.close();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }

        browser.loadHTML(new GoogleAPI().getLineChart(title, list, width, height));
        System.out.println(new GoogleAPI().getLineChart(title, list, width, height));
        System.out.println(SQL);
                
        Panel_Chart_layer.setLayout(new BorderLayout());
        browserView.setSize(1251, 534);
        Panel_Chart_layer.add(browserView, BorderLayout.CENTER);
        Panel_Chart_layer.setComponentZOrder(browserView, 0);
        Panel_Chart_layer.revalidate();
        Panel_Chart_layer.repaint();
    }//GEN-LAST:event_btnDrawActionPerformed

    // <editor-fold defaultstate="collapsed" desc="TimePick">
    private void TimeHourFromStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TimeHourFromStateChanged
        int value = Integer.parseInt(String.valueOf(TimeHourFrom.getValue()));
        if (value > 24) {
            TimeHourFrom.setValue(23);
        } else if (value > 23) {
            TimeHourFrom.setValue(0);
        } else if (value < -1) {
            TimeHourFrom.setValue(0);
        } else if (value < 0) {
            TimeHourFrom.setValue(23);
        }
    }//GEN-LAST:event_TimeHourFromStateChanged

    private void TimeHourToStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TimeHourToStateChanged
        int value = Integer.parseInt(String.valueOf(TimeHourTo.getValue()));
        if (value > 23) {
            TimeHourTo.setValue(23);
        } else if (value < 0) {
            TimeHourTo.setValue(0);
        }
    }//GEN-LAST:event_TimeHourToStateChanged

    private void TimeMinuteFromStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TimeMinuteFromStateChanged
        int value = Integer.parseInt(String.valueOf(TimeMinuteFrom.getValue()));
        if (value > 59) {
            TimeMinuteFrom.setValue(59);
        } else if (value < 0) {
            TimeMinuteFrom.setValue(0);
        }
    }//GEN-LAST:event_TimeMinuteFromStateChanged

    private void TimeMinuteToStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TimeMinuteToStateChanged
        int value = Integer.parseInt(String.valueOf(TimeMinuteTo.getValue()));
        if (value > 59) {
            TimeMinuteTo.setValue(59);
        } else if (value < 0) {
            TimeMinuteTo.setValue(0);
        }
    }//GEN-LAST:event_TimeMinuteToStateChanged
// </editor-fold> 
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FileWriter writer = null;
        try {
            String csvFile = "./abc.csv";
            jFileChooser1.showSaveDialog(null);
            writer = new FileWriter(csvFile);
            CSV_Export.writeLine(writer, Arrays.asList("a", "b", "c", "d"));
            //custom separator + quote
            CSV_Export.writeLine(writer, Arrays.asList("aaa", "bb,b", "cc,c"), ',', '"');
            //custom separator + quote
            CSV_Export.writeLine(writer, Arrays.asList("aaa", "bbb", "cc,c"), '|', '\'');
            //double-quotes
            CSV_Export.writeLine(writer, Arrays.asList("aaa", "bbb", "cc\"c"));
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println("IOException : " + ex.getMessage());
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                System.out.println("IOException : " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooserFrom;
    private com.toedter.calendar.JDateChooser DateChooserTo;
    private javax.swing.JPanel Panel_Chart;
    private javax.swing.JPanel Panel_Chart_layer;
    private javax.swing.JPanel Panel_Main;
    private javax.swing.JTabbedPane TabbedPane1;
    private javax.swing.JSpinner TimeHourFrom;
    private javax.swing.JSpinner TimeHourTo;
    private javax.swing.JSpinner TimeMinuteFrom;
    private javax.swing.JSpinner TimeMinuteTo;
    private javax.swing.JButton btnDraw;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblFromHour;
    private javax.swing.JLabel lblFromMinute;
    private javax.swing.JLabel lblTo;
    private javax.swing.JLabel lblToHour;
    private javax.swing.JLabel lblToMinute;
    private javax.swing.JTextField txtHum;
    private javax.swing.JTextField txtTem;
    // End of variables declaration//GEN-END:variables
}
