import static com.teamdev.jxbrowser.engine.RenderingMode.*;
import com.teamdev.jxbrowser.browser.Browser;
import com.teamdev.jxbrowser.engine.Engine;
import com.teamdev.jxbrowser.engine.EngineOptions;
import com.teamdev.jxbrowser.event.*;
import com.teamdev.jxbrowser.view.swing.BrowserView;
import java.awt.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainFrame extends javax.swing.JFrame {
    LoginFrame loginform = null;
    EngineOptions options =
		    EngineOptions.newBuilder(HARDWARE_ACCELERATED).build();
		Engine engine = Engine.newInstance(options);
    private Browser browser = engine.newBrowser();
    private BrowserView browserView = BrowserView.newInstance(browser);
    Calendar cal = Calendar.getInstance();
    ImageIcon img = new ImageIcon("./src/img/icon.png");
    Timer m_timer = new Timer();
    DB_CONN DBM = new DB_CONN();
    
    public MainFrame() {
        initComponents();
        initMainFrame();
    }

    public MainFrame(LoginFrame loginform) {
        this.loginform = loginform;
        initComponents();
        initMainFrame();
    }
    
    private void initMainFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Chart System");
        setVisible(true);
        setResizable(true);
        setSize(1300,760 );  
        setLocationRelativeTo(null);
        setIconImage(img.getImage());
        getContentPane().setBackground(Color.white);
        Panel_Chart.setComponentZOrder(Panel_Chart_layer, 2);
        lblUser.setText("User : " + loginform.txtID.getText());
        
        try {
            DBM.strURL += "inhatc_db";
            DBM.dbOpen();
            //DBM.dbClose();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
        
        /*browser.addLoadListener(new LoadAdapter(){
            @Override
            public void onFinishLoadingFrame(FinishLoadingEvent event){
               if (event.isMainFrame()) {
                   System.out.println("HTML 문서가 로드되었습니다.");
               }
            }
        });*/
        
        TimerTask m_task = new TimerTask(){
            @Override
            public void run() {
                String SQL = "select * from dataset order by datatime desc limit 1";
                try {
                    DBM.DB_rs = DBM.DB_stmt.executeQuery(SQL);
                    while(DBM.DB_rs.next()){
                        txtTem.setText(DBM.DB_rs.getString("tem") + " ℃");
                        txtHum.setText(DBM.DB_rs.getString("hum") + " %");

                    }
                    DBM.DB_rs.close();
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
        
        Panel_Chart_layer.setLayout(new BorderLayout());
        Panel_Chart_layer.add(browserView, BorderLayout.CENTER);
        Panel_Chart_layer.setComponentZOrder(browserView, 0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jFileChooser1 = new javax.swing.JFileChooser();
        btnLogout = new javax.swing.JButton();
        TabbedPane1 = new javax.swing.JTabbedPane();
        Panel_Main = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTem = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtHum = new javax.swing.JTextField();
        main_background = new javax.swing.JLabel();
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
        btnExport = new javax.swing.JButton();
        lblUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        TabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        TabbedPane1.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        TabbedPane1.setMinimumSize(new java.awt.Dimension(1280, 691));
        TabbedPane1.setPreferredSize(new java.awt.Dimension(1280, 691));

        Panel_Main.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Main.setPreferredSize(new java.awt.Dimension(1000, 700));
        Panel_Main.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255, 180));

        jLabel1.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        jLabel1.setText("현재 온도");

        txtTem.setEditable(false);
        txtTem.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTem)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(txtTem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_Main.add(jPanel1);
        jPanel1.setBounds(230, 260, 190, 120);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255, 180));

        jLabel2.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N
        jLabel2.setText("현재 습도");

        txtHum.setEditable(false);
        txtHum.setFont(new java.awt.Font("굴림", 1, 36)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtHum))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(11, 11, 11)
                .addComponent(txtHum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panel_Main.add(jPanel2);
        jPanel2.setBounds(610, 260, 190, 121);

        main_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/main_bg.jpg"))); // NOI18N
        Panel_Main.add(main_background);
        main_background.setBounds(0, 0, 1280, 660);

        TabbedPane1.addTab("Main", Panel_Main);

        Panel_Chart.setBackground(new java.awt.Color(255, 255, 255));

        Panel_Chart_layer.setBackground(new java.awt.Color(255, 255, 255));
        Panel_Chart_layer.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chart", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("굴림", 1, 18))); // NOI18N
        Panel_Chart_layer.setMinimumSize(new java.awt.Dimension(1251, 0));
        Panel_Chart_layer.setName(""); // NOI18N
        Panel_Chart_layer.setPreferredSize(new java.awt.Dimension(1251, 526));

        javax.swing.GroupLayout Panel_Chart_layerLayout = new javax.swing.GroupLayout(Panel_Chart_layer);
        Panel_Chart_layer.setLayout(Panel_Chart_layerLayout);
        Panel_Chart_layerLayout.setHorizontalGroup(
            Panel_Chart_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        Panel_Chart_layerLayout.setVerticalGroup(
            Panel_Chart_layerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        btnDraw.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnDraw.setText("Draw");
        btnDraw.setMaximumSize(new java.awt.Dimension(85, 25));
        btnDraw.setMinimumSize(new java.awt.Dimension(85, 25));
        btnDraw.setPreferredSize(new java.awt.Dimension(85, 25));
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
        TimeHourTo.setModel(new javax.swing.SpinnerNumberModel(0, -1, 24, 1));
        TimeHourTo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TimeHourToStateChanged(evt);
            }
        });

        lblToHour.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        lblToHour.setText("시");

        TimeMinuteFrom.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        TimeMinuteFrom.setModel(new javax.swing.SpinnerNumberModel(0, -1, 60, 1));
        TimeMinuteFrom.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TimeMinuteFromStateChanged(evt);
            }
        });

        TimeMinuteTo.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        TimeMinuteTo.setModel(new javax.swing.SpinnerNumberModel(0, -1, 60, 1));
        TimeMinuteTo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                TimeMinuteToStateChanged(evt);
            }
        });

        lblFromMinute.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        lblFromMinute.setText("분");

        lblToMinute.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        lblToMinute.setText("분");

        btnExport.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        btnExport.setText("Export");
        btnExport.setMaximumSize(new java.awt.Dimension(85, 25));
        btnExport.setMinimumSize(new java.awt.Dimension(85, 25));
        btnExport.setPreferredSize(new java.awt.Dimension(85, 25));
        btnExport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_ChartLayout = new javax.swing.GroupLayout(Panel_Chart);
        Panel_Chart.setLayout(Panel_ChartLayout);
        Panel_ChartLayout.setHorizontalGroup(
            Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_ChartLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panel_Chart_layer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                .addComponent(DateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimeHourFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFromHour)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TimeMinuteFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFromMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(Panel_ChartLayout.createSequentialGroup()
                                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(Panel_ChartLayout.createSequentialGroup()
                                        .addComponent(DateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimeHourTo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblToHour)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(TimeMinuteTo, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lblToMinute, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblFrom)
                                    .addComponent(lblTo))
                                .addGap(18, 18, 18)
                                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 799, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_ChartLayout.setVerticalGroup(
            Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_ChartLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFrom)
                .addGap(3, 3, 3)
                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateChooserFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimeHourFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFromHour)
                        .addComponent(TimeMinuteFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFromMinute)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTo)
                    .addComponent(btnExport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_ChartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TimeHourTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblToHour)
                        .addComponent(TimeMinuteTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblToMinute)
                        .addComponent(btnDraw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DateChooserTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Panel_Chart_layer, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
                .addContainerGap())
        );

        TabbedPane1.addTab("Chart", Panel_Chart);

        lblUser.setFont(new java.awt.Font("굴림", 0, 14)); // NOI18N
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLogout))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        loginform.txtID.setText("");            //텍스트필드 초기화
        loginform.txtPW.setText("");
        loginform.txtID.requestFocus();         //포커스 설정
        loginform.txtID.setFocusable(true);
        try {                                   //db 재연결
            DBM.dbClose();
            loginform.DBM.dbOpen();
        } catch (IOException ex) {
            System.out.println("SQLException : " + ex.getMessage());
        }
        loginform.show();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            DBM.dbClose();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        }
    }//GEN-LAST:event_formWindowClosing

    private String makeSQL(){
    	String SQL = "";
        String From = "";
        String To = "";
        
        SimpleDateFormat getDate = new SimpleDateFormat("yyyyMMdd");
        
        From = getDate.format(DateChooserFrom.getDate());
        if(String.valueOf(TimeHourFrom.getValue()).length() < 2)
            From += "0";
        From += TimeHourFrom.getValue();
        if(String.valueOf(TimeMinuteFrom.getValue()).length() < 2)
            From += "0";
        From += TimeMinuteFrom.getValue();
        From += "00";
        
        To = getDate.format(DateChooserTo.getDate());
        if(String.valueOf(TimeHourTo.getValue()).length() < 2)
            To += "0";
        To += TimeHourTo.getValue();
        if(String.valueOf(TimeMinuteTo.getValue()).length() < 2)
            To += "0";
        To += TimeMinuteTo.getValue();
        To += "59";

        SQL = "select * from dataset where datatime between " + From + " and " + To + " order by datatime desc";
        return SQL;
    }
    
    private void DrawChart() {
        String title = "title";
        ArrayList<ChartElement> list = new ArrayList<ChartElement>();

        try {
            String SQL = makeSQL();
            
            DBM.DB_rs = DBM.DB_stmt.executeQuery(SQL);
            while(DBM.DB_rs.next()){
                list.add(new ChartElement(DBM.DB_rs.getString("datatime"), DBM.DB_rs.getFloat("tem"), DBM.DB_rs.getFloat("hum")));
            }
            DBM.DB_rs.close();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
        } 

        browser.mainFrame().ifPresent(frame ->
        	frame.loadHtml(new GoogleAPI().getLineChart(title, list)));
        browserView.setSize(Panel_Chart_layer.getWidth()-20, Panel_Chart_layer.getHeight()-15);
        Panel_Chart_layer.revalidate();
        Panel_Chart_layer.repaint();
    }
    
    private void btnDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawActionPerformed
        DrawChart();
    }//GEN-LAST:event_btnDrawActionPerformed

    // <editor-fold defaultstate="collapsed" desc="TimePick //TimePick StateChanged Event">
    private void TimeHourFromStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TimeHourFromStateChanged
        int value = Integer.parseInt(String.valueOf(TimeHourFrom.getValue()));  //TimeHourFrom의 값을 가져옴
        cal.setTime(DateChooserFrom.getDate()); //DateChooserFrom의 값을 가져와 cal 객체에 세팅
        if (value > 23) {   //TimeHourFrom의 값이 23을 초과하면 
            TimeHourFrom.setValue(0);   //TimeHourFrom값을 0으로 하고
            cal.add(Calendar.DATE, 1);  //DateChooserFrom의 값을 하루 더한다.
            DateChooserFrom.setDate(cal.getTime());
        } else if (value < 0) {    //TimeHourFrom의 값이 0 미만이면 
            TimeHourFrom.setValue(23);  //TimeHourFrom값을 23으로 하고
            cal.add(Calendar.DATE, -1); //DateChooserFrom의 값을 하루 뺀다.
            DateChooserFrom.setDate(cal.getTime());
        }
    }//GEN-LAST:event_TimeHourFromStateChanged

    private void TimeHourToStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TimeHourToStateChanged
        int value = Integer.parseInt(String.valueOf(TimeHourTo.getValue()));
        cal.setTime(DateChooserTo.getDate());
        if (value > 23) {
            TimeHourTo.setValue(0);          
            cal.add(Calendar.DATE, 1);
            DateChooserTo.setDate(cal.getTime());
        } else if (value < 0) {
            TimeHourTo.setValue(23);
            cal.add(Calendar.DATE, -1);
            DateChooserTo.setDate(cal.getTime());
        }
    }//GEN-LAST:event_TimeHourToStateChanged

    private void TimeMinuteFromStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TimeMinuteFromStateChanged
        int value = Integer.parseInt(String.valueOf(TimeMinuteFrom.getValue()));        //TimeMinuteFrom의 값을 int형으로 저장
        int v_TimeHourFrom = Integer.parseInt(String.valueOf(TimeHourFrom.getValue())); //TimeHourFrom의 값을 int형으로 저장
        if (value > 59) {                              //TimeMinuteFrom값이 59 초과이면
            TimeMinuteFrom.setValue(0);                //TimeMinuteFrom 값을 0으로 하고
            TimeHourFrom.setValue(v_TimeHourFrom + 1); //TimeHourFrom 값을 1증가한다.
        } else if (value < 0) {                        //TimeMinuteFrom값이 0 미만이면
            TimeMinuteFrom.setValue(59);               //TimeMinuteFrom 값을 59으로 하고
            TimeHourFrom.setValue(v_TimeHourFrom - 1); //TimeHourFrom 값을 1감소한다.
        }
    }//GEN-LAST:event_TimeMinuteFromStateChanged

    private void TimeMinuteToStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_TimeMinuteToStateChanged
        int value = Integer.parseInt(String.valueOf(TimeMinuteTo.getValue()));
        int v_TimeHourTo = Integer.parseInt(String.valueOf(TimeHourTo.getValue()));
        if (value > 59) {
            TimeMinuteTo.setValue(0);
            TimeHourTo.setValue(v_TimeHourTo + 1);
        } else if (value < 0) {
            TimeMinuteTo.setValue(59);
            TimeHourTo.setValue(v_TimeHourTo - 1);
        }
    }//GEN-LAST:event_TimeMinuteToStateChanged
// </editor-fold> 
    
    private void btnExportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportActionPerformed
        PrintWriter out = null;
        String SQL = makeSQL();
        String csvFile = "";
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV Files (*.csv)", "csv");   //jFileChooser1 확장자 지정
        jFileChooser1.setFileFilter(filter);    //jFileChooser1 확장자 필터 적용
        jFileChooser1.setSelectedFile(new File("Export.csv"));  //jFileChooser1 default 파일명 지정
        int sv = jFileChooser1.showSaveDialog(null);  //jFileChooser1 띄우고 버튼 액션을 int로 저장
        if (sv == 0) {      // jFileChooser1가 저장 버튼을 눌렀을 때
            //csvFile = jFileChooser1.getCurrentDirectory().getAbsolutePath();
            csvFile += jFileChooser1.getSelectedFile();     //파일 디렉터리 및 파일명 저장
            if (!csvFile.endsWith(".csv"))  //csv 확장자 확인 없으면 변환
                csvFile += ".csv";
            System.out.println(csvFile);
            try {
                File saveFile = new File(csvFile);
                out = new PrintWriter(new FileWriter(saveFile, true));
                if (!saveFile.exists()) {       //파일이 없으면 파일 생성
                    saveFile.createNewFile();
                }
                CSV_Export.writeLine(out, Arrays.asList("no", "tem", "hum", "datetime"));   //csv파일 헤더
                try {
                    //DBM.DB_rs = DBM.DB_stmt.executeQuery(SQL);  //쿼리를 날리고 while문으로 csv파일 내용 작성
                    DBM.DB_rs = DBM.DB_stmt.executeQuery(SQL);
                    while(DBM.DB_rs.next()){
                        CSV_Export.writeLine(out, Arrays.asList(String.valueOf(DBM.DB_rs.getRow()), DBM.DB_rs.getString("tem"), DBM.DB_rs.getString("hum"), DBM.DB_rs.getString("datatime")));
                    }
                    DBM.DB_rs.close();
                } catch (Exception e) {
                    System.out.println("SQLException : " + e.getMessage());
                }
                out.flush();    //csv파일 저장
                JOptionPane.showMessageDialog(this, "저장완료", "저장완료", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                System.out.println("IOException : " + e.getMessage());
            } finally {
                out.close();
            }      
        } else {        //jFileChooser1에서 닫기를 눌렀을 때
            return;
        }
    }//GEN-LAST:event_btnExportActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        main_background.setSize(Panel_Main.getWidth(),Panel_Main.getHeight());
    }//GEN-LAST:event_formComponentResized

    public static void main(String args[]) {
        System.setProperty("jxbrowser.license.key", "1BNDHFSC1FVNKU8YRT9R7DSJUDU2U1ELTUVOTWL609ET3OFVBFRND30M2G576QFHUNRQP1");
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
    private javax.swing.JButton btnExport;
    private javax.swing.JButton btnLogout;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblFrom;
    private javax.swing.JLabel lblFromHour;
    private javax.swing.JLabel lblFromMinute;
    private javax.swing.JLabel lblTo;
    private javax.swing.JLabel lblToHour;
    private javax.swing.JLabel lblToMinute;
    private javax.swing.JLabel lblUser;
    private javax.swing.JLabel main_background;
    private javax.swing.JTextField txtHum;
    private javax.swing.JTextField txtTem;
    // End of variables declaration//GEN-END:variables
}
