
import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.events.FinishLoadingEvent;
import com.teamdev.jxbrowser.chromium.events.LoadAdapter;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;
import java.awt.BorderLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class MainFrame extends javax.swing.JFrame {
    ImageIcon img = new ImageIcon("./src/icon.png");
    private Browser browser = new Browser();
    private BrowserView browserView = new BrowserView(browser);
    DB_CONN DBM = new DB_CONN();
    
    public MainFrame() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Chart System");
        setVisible(true);
        setResizable(true);
        setSize(1300,720 );  
        setLocationRelativeTo(null);
        setIconImage(img.getImage());
        Panel_Chart.setComponentZOrder(DateChooserTo, 0);
        Panel_Chart.setComponentZOrder(DateChooserFrom, 1);
        Panel_Chart.setComponentZOrder(Panel_Chart_layer, 2);
        
        try {
            DBM.strURL += "DHT_db";
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
       
        DateTime();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        TabbedPane1 = new javax.swing.JTabbedPane();
        Panel_Main = new javax.swing.JPanel();
        Panel_Chart = new javax.swing.JPanel();
        Panel_Chart_layer = new javax.swing.JPanel();
        btnDraw = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton3 = new javax.swing.JButton();
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

        TabbedPane1.setMinimumSize(new java.awt.Dimension(1280, 691));
        TabbedPane1.setPreferredSize(new java.awt.Dimension(1280, 691));

        Panel_Main.setPreferredSize(new java.awt.Dimension(1000, 700));

        javax.swing.GroupLayout Panel_MainLayout = new javax.swing.GroupLayout(Panel_Main);
        Panel_Main.setLayout(Panel_MainLayout);
        Panel_MainLayout.setHorizontalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        Panel_MainLayout.setVerticalGroup(
            Panel_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 662, Short.MAX_VALUE)
        );

        TabbedPane1.addTab("Main", Panel_Main);

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
            .addGap(0, 534, Short.MAX_VALUE)
        );

        btnDraw.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnDraw.setText("Draw");
        btnDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jButton3.setText("jButton3");

        lblFrom.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        lblFrom.setText("From");

        DateChooserFrom.setDateFormatString("yyyy. MM. dd");
        DateChooserFrom.setDoubleBuffered(false);
        DateChooserFrom.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N

        lblTo.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        lblTo.setText("To");

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

        javax.swing.GroupLayout Panel_ChartLayout = new javax.swing.GroupLayout(Panel_Chart);
        Panel_Chart.setLayout(Panel_ChartLayout);
        Panel_ChartLayout.setHorizontalGroup(
            Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ChartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Chart_layer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblFrom)
                            .addComponent(lblTo)
                            .addComponent(DateChooserFrom, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(DateChooserTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                .addComponent(TimeHourFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFromHour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TimeMinuteFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFromMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                .addComponent(TimeHourTo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblToHour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TimeMinuteTo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblToMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDraw)))
                        .addGap(0, 722, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_ChartLayout.setVerticalGroup(
            Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ChartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(TimeHourFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFromHour)
                                    .addComponent(TimeMinuteFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFromMinute)))
                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                .addComponent(lblFrom)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(TimeHourTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblToHour)
                                .addComponent(TimeMinuteTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblToMinute)
                                .addComponent(btnDraw))
                            .addComponent(DateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panel_Chart_layer, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
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
        int width = 600;
        int height = 600;
        String From = "";
        String To = "";
        String SQL = "Select tem, hum, datetime from dht_datasheet where datetime between ";
        
        SimpleDateFormat getDate = new SimpleDateFormat("yyyyMMdd");
        From = getDate.format(DateChooserFrom.getDate());
        if(String.valueOf(TimeHourFrom.getValue()).length() < 2)
            From += "0";
        From += TimeHourFrom.getValue();
        if(String.valueOf(TimeMinuteFrom.getValue()).length() < 2)
            From += "0";
        From += TimeMinuteFrom.getValue();
        From += "00";
        SQL += From + " and ";
        To = getDate.format(DateChooserTo.getDate());
        if(String.valueOf(TimeHourTo.getValue()).length() < 2)
            To += "0";
        To += TimeHourTo.getValue();
        if(String.valueOf(TimeMinuteTo.getValue()).length() < 2)
            To += "0";
        To += TimeMinuteTo.getValue();
        To += "59";
        SQL += To;
        
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
    private javax.swing.JButton jButton3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblFromHour;
    private javax.swing.JLabel lblFromMinute;
    private javax.swing.JLabel lblTo;
    private javax.swing.JLabel lblToHour;
    private javax.swing.JLabel lblToMinute;
    // End of variables declaration//GEN-END:variables
}
