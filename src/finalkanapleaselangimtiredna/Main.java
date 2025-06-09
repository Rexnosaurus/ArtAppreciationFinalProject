package finalkanapleaselangimtiredna;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.Insets;
import java.awt.Container;
import java.lang.reflect.GenericSignatureFormatError;

/**
 *
 * @author rexiepimentelMBP
 */
public class Main extends javax.swing.JFrame {

    int worldLevel = 19;
    int totalDamage;
    
    String stage; 
    
    Rex rex = new Rex();
    Arth arth = new Arth();
    Aaron aaron = new Aaron();
    Party playerParty = new Party();
    
    Enemy enemy = Enemy.generateEnemy(1, playerParty.getPartyLevel(), worldLevel);
    
    Player activeCharacter;
    
    // Frames
    Shop shop;
    Inventory inventory;
    
    // Content Panes
    Container mainContentPane;
    Container shopContentPane;
    Container invContentPane;
    
    public Main() {
        initComponents();
        activeCharacter = arth;
        
        rex.setUnlocked(false);
        aaron.setUnlocked(false);
        
        playerParty.getInventory().setActiveCharacter(activeCharacter);
        playerParty.getInventory().setMoney(500);
        
        shop = new Shop(playerParty.getInventory());
        shop.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        inventory = new Inventory(playerParty.getInventory());
        inventory.setDefaultCloseOperation(javax.swing.JFrame.HIDE_ON_CLOSE);
        
        // shop.setSize();
        
        shop.setMainFrame(this);
        inventory.setMainFrame(this);
        shop.setInvFrame(inventory);
        inventory.setShopFrame(shop);
        
        btnAaron.setVisible(true);
        btnRex.setVisible(true);
        
        playerParty.addMember(arth);
        playerParty.addMember(rex);
        playerParty.addMember(aaron);
        
        stageChecker();
        updateLabelAndBars();
        

        
        mainContentPane = this.getContentPane();
        shopContentPane = shop.getContentPane();
        invContentPane = inventory.getContentPane();
    }

    Timer timer = new Timer(4000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            lblSkill2Icon.setIcon(null);
            }
        }
    );


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnArth = new javax.swing.JButton();
        btnRex = new javax.swing.JButton();
        btnAaron = new javax.swing.JButton();
        Shop = new javax.swing.JButton();
        Inventory = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        PanelBattlemiscellaneous = new javax.swing.JPanel();
        PanelPlayerInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pBarActiveCharacterHP = new javax.swing.JProgressBar();
        pBarActiveCharacterMana = new javax.swing.JProgressBar();
        lblActiveCharacter = new javax.swing.JLabel();
        lblActiveCharacterHpAndMaxHp = new javax.swing.JLabel();
        lblActiveCharacterManaAndMaxMana = new javax.swing.JLabel();
        lblActiveCharacterXpCurrAndMax = new javax.swing.JLabel();
        lblPlayersLevel = new javax.swing.JLabel();
        PanelBattleDoings = new javax.swing.JPanel();
        btnBasicAttack = new javax.swing.JButton();
        btnDodge = new javax.swing.JButton();
        btnSkill1 = new javax.swing.JButton();
        btnSkill2 = new javax.swing.JButton();
        PanelEnemyInfo = new javax.swing.JPanel();
        lblEnemyNameandLevel = new javax.swing.JLabel();
        pBarEnemyHp = new javax.swing.JProgressBar();
        lblEnemyHpAndMaxHp = new javax.swing.JLabel();
        lblFloorLevel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblSkill2Icon = new javax.swing.JLabel();
        txtTotalDamage = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnArth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/128bit/iconArth.png"))); // NOI18N
        btnArth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArthMouseClicked(evt);
                SwitchCharacter(evt);
            }
        });
        btnArth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArthActionPerformed(evt);
            }
        });
        jPanel1.add(btnArth, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 88, 75, 122));

        btnRex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/128bit/iconRex.png"))); // NOI18N
        btnRex.setEnabled(false);
        btnRex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArthMouseClicked(evt);
            }
        });
        btnRex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRexActionPerformed(evt);
            }
        });
        jPanel1.add(btnRex, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 216, 75, 122));

        btnAaron.setIcon(new javax.swing.ImageIcon(getClass().getResource("/128bit/iconAaron.png"))); // NOI18N
        btnAaron.setEnabled(false);
        btnAaron.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArthMouseClicked(evt);
            }
        });
        btnAaron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAaronActionPerformed(evt);
            }
        });
        jPanel1.add(btnAaron, new org.netbeans.lib.awtextra.AbsoluteConstraints(9, 344, 75, 122));

        Shop.setText("Shop");
        Shop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShopActionPerformed(evt);
            }
        });
        jPanel1.add(Shop, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 634, 75, -1));

        Inventory.setText("Bag");
        Inventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryActionPerformed(evt);
            }
        });
        jPanel1.add(Inventory, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 601, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        PanelBattlemiscellaneous.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PanelPlayerInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("HP:");

        jLabel2.setText("Mana:");

        lblActiveCharacter.setText("Active Character Name");

        lblActiveCharacterHpAndMaxHp.setText("HpAndMaxHp");

        lblActiveCharacterManaAndMaxMana.setText("ManaAndMaxMana");

        lblActiveCharacterXpCurrAndMax.setText("ActiveCharacterXp");

        lblPlayersLevel.setText("PlayersLevel");

        javax.swing.GroupLayout PanelPlayerInfoLayout = new javax.swing.GroupLayout(PanelPlayerInfo);
        PanelPlayerInfo.setLayout(PanelPlayerInfoLayout);
        PanelPlayerInfoLayout.setHorizontalGroup(
            PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPlayerInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPlayerInfoLayout.createSequentialGroup()
                        .addComponent(lblActiveCharacter)
                        .addGap(18, 18, 18)
                        .addComponent(lblPlayersLevel)
                        .addGap(18, 18, 18)
                        .addComponent(lblActiveCharacterXpCurrAndMax))
                    .addGroup(PanelPlayerInfoLayout.createSequentialGroup()
                        .addGroup(PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pBarActiveCharacterMana, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pBarActiveCharacterHP, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblActiveCharacterHpAndMaxHp)
                            .addComponent(lblActiveCharacterManaAndMaxMana))))
                .addContainerGap(145, Short.MAX_VALUE))
        );
        PanelPlayerInfoLayout.setVerticalGroup(
            PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPlayerInfoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPlayersLevel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblActiveCharacter)
                        .addComponent(lblActiveCharacterXpCurrAndMax)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPlayerInfoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblActiveCharacterHpAndMaxHp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblActiveCharacterManaAndMaxMana))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPlayerInfoLayout.createSequentialGroup()
                        .addGroup(PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pBarActiveCharacterHP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelPlayerInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(pBarActiveCharacterMana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(26, 26, 26))
        );

        PanelBattleDoings.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PanelBattleDoings.setLayout(new java.awt.GridLayout(1, 0, 8, 14));

        btnBasicAttack.setBackground(new java.awt.Color(254, 254, 254));
        btnBasicAttack.setText("Basic Attack");
        btnBasicAttack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionTurnHandler(evt);
            }
        });
        btnBasicAttack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBasicAttackActionPerformed(evt);
            }
        });
        PanelBattleDoings.add(btnBasicAttack);

        btnDodge.setBackground(new java.awt.Color(254, 254, 254));
        btnDodge.setText("Dodge");
        btnDodge.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionTurnHandler(evt);
            }
        });
        btnDodge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodgeActionPerformed(evt);
            }
        });
        PanelBattleDoings.add(btnDodge);

        btnSkill1.setBackground(new java.awt.Color(254, 254, 254));
        btnSkill1.setText("Skill1");
        btnSkill1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnSkill1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionTurnHandler(evt);
            }
        });
        btnSkill1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkill1ActionPerformed(evt);
            }
        });
        PanelBattleDoings.add(btnSkill1);

        btnSkill2.setBackground(new java.awt.Color(254, 254, 254));
        btnSkill2.setText("Skill2");
        btnSkill2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionTurnHandler(evt);
            }
        });
        btnSkill2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkill2ActionPerformed(evt);
            }
        });
        PanelBattleDoings.add(btnSkill2);

        javax.swing.GroupLayout PanelBattlemiscellaneousLayout = new javax.swing.GroupLayout(PanelBattlemiscellaneous);
        PanelBattlemiscellaneous.setLayout(PanelBattlemiscellaneousLayout);
        PanelBattlemiscellaneousLayout.setHorizontalGroup(
            PanelBattlemiscellaneousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBattlemiscellaneousLayout.createSequentialGroup()
                .addComponent(PanelPlayerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelBattleDoings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelBattlemiscellaneousLayout.setVerticalGroup(
            PanelBattlemiscellaneousLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBattleDoings, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelPlayerInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(PanelBattlemiscellaneous);
        PanelBattlemiscellaneous.setBounds(1, 584, 1100, 108);

        PanelEnemyInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblEnemyNameandLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEnemyNameandLevel.setText("lblEnemyName");

        lblEnemyHpAndMaxHp.setText("HpAndMaxHp");

        lblFloorLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFloorLevel.setText("Floor Level");

        javax.swing.GroupLayout PanelEnemyInfoLayout = new javax.swing.GroupLayout(PanelEnemyInfo);
        PanelEnemyInfo.setLayout(PanelEnemyInfoLayout);
        PanelEnemyInfoLayout.setHorizontalGroup(
            PanelEnemyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEnemyInfoLayout.createSequentialGroup()
                .addGap(287, 287, 287)
                .addGroup(PanelEnemyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblEnemyNameandLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addComponent(lblFloorLevel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBarEnemyHp, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEnemyHpAndMaxHp)
                .addContainerGap(245, Short.MAX_VALUE))
        );
        PanelEnemyInfoLayout.setVerticalGroup(
            PanelEnemyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEnemyInfoLayout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(lblEnemyNameandLevel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelEnemyInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pBarEnemyHp, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEnemyHpAndMaxHp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFloorLevel)
                .addContainerGap())
        );

        jPanel2.add(PanelEnemyInfo);
        PanelEnemyInfo.setBounds(1, 1, 1100, 77);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSkill2Icon.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblSkill2Icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(lblSkill2Icon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1090, 350));

        txtTotalDamage.setText("Total Damage Per Enemy");
        jPanel3.add(txtTotalDamage, new org.netbeans.lib.awtextra.AbsoluteConstraints(921, 60, 180, 60));

        jPanel2.add(jPanel3);
        jPanel3.setBounds(1, 86, 1100, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1107, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 694, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void actionTurnHandler(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actionTurnHandler
        
    }//GEN-LAST:event_actionTurnHandler

    
    private void btnBasicAttackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBasicAttackActionPerformed
        activeCharacter.basicAttack(enemy);
        
        // If enemy does not die, take turn, else generate new enemy and skip turn
        if(!checkEnemyHp()) {
           enemyTakeTurn(); 
        }
        updateLabelAndBars();
    }//GEN-LAST:event_btnBasicAttackActionPerformed

    private void btnDodgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodgeActionPerformed
        // TODO add your handling code here:
        
        updateLabelAndBars();
        if (activeCharacter.equals(arth)) {
            updateLabelAndBars();
            arth.dodge();
            //lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2ArthAnimation.gif")));
            //timer.start();
            //timer.setRepeats(false);
            enemyTakeTurn();
            arth.resetDodge();
            

        } else if (activeCharacter.equals(aaron)) {
            updateLabelAndBars();
            aaron.dodge();
            //lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2AaronAnimation.gif")));
            //timer.start();
            //timer.setRepeats(false);
            enemyTakeTurn();

        } else if (activeCharacter.equals(rex)) {
            updateLabelAndBars();
            rex.dodge();
            //lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2RexAnimation.gif")));
            //timer.start();
            //timer.setRepeats(false);
            enemyTakeTurn();
        }
        updateLabelAndBars();
    }//GEN-LAST:event_btnDodgeActionPerformed

    private void btnSkill1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:

        updateLabelAndBars();
        if (activeCharacter.equals(arth)) {
            updateLabelAndBars();
            arth.skill1(enemy);
            //lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2ArthAnimation.gif")));
            //timer.start();
            //timer.setRepeats(false);
            if(!checkEnemyHp()) {
                enemyTakeTurn(); 
            }
            updateLabelAndBars();
            arth.resetDodge();

        } else if (activeCharacter.equals(aaron)) {
            updateLabelAndBars();
            
            aaron.instantSleep = true;
            aaron.instantSleepTurnCount = 5;
            
            aaron.skill1();
            //lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2AaronAnimation.gif")));
            //timer.start();
            //timer.setRepeats(false);
            lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2AaronAnimation.gif")));
            timer.start();
            timer.setRepeats(false);
            
            checkSkillCooldown();
            
            if(!checkEnemyHp()) {
                enemyTakeTurn(); 
            }
            updateLabelAndBars();

        } else if (activeCharacter.equals(rex)) {
            updateLabelAndBars();
            rex.skill1(enemy);
            //lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2RexAnimation.gif")));
            //timer.start();
            //timer.setRepeats(false);
            if(!checkEnemyHp()) {
                enemyTakeTurn(); 
            }
            updateLabelAndBars();

        }
        
        updateLabelAndBars();
        checkSkillCooldown();
    }                                             

    private void btnSkill2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkill2ActionPerformed

        if (activeCharacter.equals(arth)) {
            updateLabelAndBars();
            lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2ArthAnimation.gif")));
            timer.start();
            timer.setRepeats(false);
            
            arth.hackerMan = true;
            
            System.out.println(arth.hackerMan);
            arth.turnCount = 5;
            
            checkSkillCooldown();
            
            enemyTakeTurn();            

            try (InputStream is = getClass().getResourceAsStream("/Music/arthTheme.wav")) {
                if (is == null) throw new RuntimeException("File not found!");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new BufferedInputStream(is)));
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        
        } else if (activeCharacter.equals(aaron)) {
            updateLabelAndBars();
            lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2AaronAnimation.gif")));
            timer.start();
            timer.setRepeats(false);

            aaron.spreadCurse = true;
            
            aaron.spreadCurseTurnCount = 5;
            
            checkSkillCooldown();
            
            enemyTakeTurn();
            try (InputStream is = getClass().getResourceAsStream("/Music/aaronTheme.wav")) {
                if (is == null) throw new RuntimeException("File not found!");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new BufferedInputStream(is)));
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        } else if (activeCharacter.equals(rex)) {
            updateLabelAndBars();
            lblSkill2Icon.setIcon(new ImageIcon(getClass().getResource("/Animations/skill2RexAnimation.gif")));
            timer.start();
            timer.setRepeats(false);
            
            rex.skill2(enemy);
            checkSkillCooldown();
            
            
            enemy.isDead = true;
            checkEnemyHp();

            try (InputStream is = getClass().getResourceAsStream("/Music/arthTheme.wav")) {
                if (is == null) throw new RuntimeException("File not found!");
                Clip clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(new BufferedInputStream(is)));
                clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            
        }
        
        checkEnemyHp();
        checkBuff();        
          
        updateLabelAndBars();
    }//GEN-LAST:event_btnSkill2ActionPerformed


    private void InventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryActionPerformed
        this.setContentPane(invContentPane);
    }//GEN-LAST:event_InventoryActionPerformed

    private void ShopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShopActionPerformed
        this.setContentPane(shopContentPane);
    }//GEN-LAST:event_ShopActionPerformed

    private void btnAaronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAaronActionPerformed
        // TODO add your handling code here:
        aaron.getStats();

        btnAaron.setSelected(true);
        btnRex.setSelected(false);
        btnArth.setSelected(false);

        playerParty.getInventory().setActiveCharacter(activeCharacter);
        btnSkill1.setText("<html>Instant<br>Sleep<html>");
        btnSkill2.setText("BadLuck");
        if(activeCharacter != aaron) {
            enemyTakeTurn();
        }
        activeCharacter = aaron;
        checkSkillCooldown();
        checkActiveCharacter();
        updateLabelAndBars();
    }//GEN-LAST:event_btnAaronActionPerformed

    private void btnRexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRexActionPerformed
        // TODO add your handling code here:
        rex.getStats();

        btnRex.setSelected(true);
        btnArth.setSelected(false);
        btnAaron.setSelected(false);

        playerParty.getInventory().setActiveCharacter(activeCharacter);
        btnSkill1.setText("<html>Mac<br>Attack<html>");
        btnSkill2.setText("<html>Money<br>Attack<html>");
        if(activeCharacter != rex) {
            enemyTakeTurn();
        }
        activeCharacter = rex;
        checkSkillCooldown();
        checkActiveCharacter();
        updateLabelAndBars();
    }//GEN-LAST:event_btnRexActionPerformed

    private void btnArthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArthActionPerformed
        // TODO add your handling code here:
        arth.getStats();

        btnArth.setSelected(true);
        btnAaron.setSelected(false);
        btnRex.setSelected(false);

        playerParty.getInventory().setActiveCharacter(activeCharacter);
        btnSkill1.setText("<html>Scolio<br>Attack<html>");
        btnSkill2.setText("Hackerman");
        if(activeCharacter != arth) {
            enemyTakeTurn();
        }
        activeCharacter = arth;
        checkActiveCharacter();
        checkSkillCooldown();
        updateLabelAndBars();
    }//GEN-LAST:event_btnArthActionPerformed

    private void btnArthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArthMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnArthMouseClicked

    private void SwitchCharacter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SwitchCharacter
        // TODO add your handling code here:
    }//GEN-LAST:event_SwitchCharacter
           
        
    public int enemyLevelRandomizer(){
        
        int playerLevel = playerParty.getPartyLevel();
        int minEnemyLevel = (playerLevel == 1) ? playerLevel : playerLevel - 1;
        int maxEnemyLevel = playerLevel + 1;

        int range = maxEnemyLevel - minEnemyLevel + 1;
        int randomEnemyLevel = (int)(Math.random() * range) + minEnemyLevel;
        
        return randomEnemyLevel;
    }
    
    private void generateEnemy(){
        int enemyLevel = enemyLevelRandomizer();
        enemy = Enemy.generateEnemy(enemyLevel, playerParty.getPartyLevel(), worldLevel);
        enemy.getStats();
    }
    
    private void stageChecker(){
        if (worldLevel <= 10) {
            stage = "Canteen";
        } else if (worldLevel <= 20) {
            stage = "Gymnasium";
        } else if (worldLevel <= 30) {
            stage = "Library";
        } else if (worldLevel <= 40) {
            stage = "DIT Building";
        } 
    }
    public void unlockCharacter(){
        
        if (worldLevel == 10) {
            btnRex.setEnabled(true);
            btnRex.setVisible(true);
            rex.setUnlocked(true);
        }
        if (worldLevel == 20) {
            btnAaron.setEnabled(true);
            btnAaron.setVisible(true);
            aaron.setUnlocked(true);
        }
    }
    public void updateLabelAndBars(){

        
        int percentageActiveCharacterHp = (activeCharacter.hp * 100) / activeCharacter.maxHp;
        int percentageActiveCharacterMana = (activeCharacter.mana * 100) / activeCharacter.maxMana;
        int percentageEnemyHp = (enemy.hp * 100) / enemy.maxHp;
        
        lblActiveCharacter.setText(activeCharacter.name);
        lblActiveCharacterHpAndMaxHp.setText(activeCharacter.hp + "/" + activeCharacter.maxHp);
        lblActiveCharacterManaAndMaxMana.setText(activeCharacter.mana + "/" + activeCharacter.maxMana);
        lblActiveCharacterXpCurrAndMax.setText(activeCharacter.getExpCurrent() + "/" + activeCharacter.getExpThreshold());
        lblPlayersLevel.setText("Level: " + playerParty.getPartyLevel());
        System.out.println("Current Party Level: "+playerParty.getPartyLevel());
        
        lblEnemyNameandLevel.setText(enemy.name + "|" + enemy.getLevel());
        lblEnemyHpAndMaxHp.setText(enemy.hp + "/" + enemy.maxHp);
        
        pBarActiveCharacterHP.setValue(percentageActiveCharacterHp);
        pBarActiveCharacterMana.setValue(percentageActiveCharacterMana);
        pBarEnemyHp.setValue(percentageEnemyHp);
        
        lblFloorLevel.setText("Stage: "+ stage +" | Level: " + worldLevel);
        
                
        checkSkillCooldown();
        checkActiveCharacterHp();        
        stageChecker();
        totalDamageHandler();
        checkBuff();
        unlockCharacter();
        
        cooldownHandler();
        
        // getCd();    
        
    }
    
    public void getCd(){
        System.out.println("===============================");
        System.out.println("Rex S1CD: " + rex.skill1Cooldown);
        System.out.println("Rex S1CD: " + rex.skill2Cooldown);
        System.out.println("Arth S1CD: " + arth.skill1Cooldown);
        System.out.println("Arth S1CD: " + arth.skill2Cooldown);
        System.out.println("Aaron S1CD: " + aaron.skill1Cooldown);
        System.out.println("Aaron S2CD: " + aaron.skill2Cooldown);
        System.out.println("===============================");
    }
    
    public void totalDamageHandler(){
        
        int currentDamage = 0;
        if (txtTotalDamage.getValue() != null) {
            currentDamage = (int) txtTotalDamage.getValue();
        }
        
        totalDamage = (int) (currentDamage + activeCharacter.damagedealt);
        
        txtTotalDamage.setValue(totalDamage);
    }
    
    public void checkActiveCharacter(){
        if (activeCharacter == arth) {
            btnSkill1.setText("<html>Scolio<br>Attack<html>");
            btnSkill2.setText("<html>HackerMan<html>");
        } else if (activeCharacter == rex) {
            btnSkill1.setText("<html>Mac<br>Attack<html>");
            btnSkill2.setText("<html>Money Bribe<html>");
        } else if (activeCharacter == aaron) {
            btnSkill1.setText("<html>Instant<br>Sleep<html>");
            btnSkill2.setText("<html>Spread Curse<html>");
        }
    }
    public boolean checkEnemyHp(){
        /*
        System.out.println("Enemy is not dead");
        
        if (enemy.hp <= 0) {
            enemy.isDead = true;
            if (enemy.isDead) {
                System.out.println("Enemy is Defeated!!!");
                worldLevel++;
                System.out.println("In checkEnemyHP: "+worldLevel);
                generateEnemy();
                int expGained = enemy.calculateExpReward();
                Player.addExperience(expGained);
                int newMoner = (int)(Math.random()*10*enemy.getLevel()*(Math.random()+1));
                sharedInventory.setMoney(sharedInventory.getMoney()+newMoner);
                System.out.println("MONEYYYYYYYYYYYYYYYYYY: "+newMoner);
                shop.updateDisplay();
                inventory.updateDisplay();
            }
        }
       */
        
        if(enemy.isDead) {
            worldLevel++;
            playerParty.addExperienceToAll(enemy.calculateExpReward());
            int newMoney = (int)(Math.random()*10*enemy.getLevel()*(Math.random()+10));
            playerParty.getInventory().addMoney(newMoney);
            generateEnemy();
            shop.updateDisplay();
            inventory.updateDisplay();
            return true;
        }
        return false;
    }
    private void checkActiveCharacterHp(){
        // if all is dead
        System.out.println(arth.hp);
        System.out.println(rex.hp);
        if(!playerParty.isPartyAlive()) {
            System.out.println("Everyone is dead");
            System.exit(0);
        }
        else if(activeCharacter.isDead) {
            if(activeCharacter == arth) {
                btnArth.setEnabled(false);
                btnArth.setSelected(false);
                if(!rex.isDead && rex.isUnlocked) {
                    activeCharacter = rex;
                }
                else if(!aaron.isDead && aaron.isUnlocked) {
                    activeCharacter = aaron;
                }
                else {
                    System.out.println("Everyone is dead");
                    System.exit(0);
                }
            }
            else if(activeCharacter == rex) {
                btnRex.setEnabled(false);
                btnRex.setSelected(false);
                if(!aaron.isDead && aaron.isUnlocked) {
                    activeCharacter = aaron;
                }
                else if(!arth.isDead && arth.isUnlocked) {
                    activeCharacter = arth;
                }
                else {
                    System.out.println("Everyone is dead");
                    System.exit(0);
                }
            }
            else if(activeCharacter == aaron) {
                btnAaron.setEnabled(false);
                btnAaron.setSelected(false);
                if(!arth.isDead && arth.isUnlocked) {
                    activeCharacter = aaron;
                }
                else if(!rex.isDead && rex.isUnlocked) {
                    activeCharacter = rex;
                }
                else {
                    System.out.println("Everyone is dead");
                    System.exit(0);
                }
            }
        }
    }
    
    public void checkBuff(){
        
        if (arth.hackerMan == true) {
            arth.skill2(enemy);
            System.out.println("HackerMan Turn Left: "+arth.turnCount);
        }
        
        if (aaron.spreadCurse == true) {
            aaron.skill2(enemy);
            System.out.println("Curse Turn Left: "+aaron.spreadCurseTurnCount);
        }

    }
    
    public void checkSkillCooldown(){
        
        //Rex Skill 1 Cooldown
        if (activeCharacter == rex && rex.skill1Cooldown > 0) {
            btnSkill1.setEnabled(false);
            btnSkill1.setText("<html>Mac Attack<br>(" + rex.skill1Cooldown + ")<html>");
        } else if (activeCharacter == rex && rex.skill1Cooldown <= 0) {
            btnSkill1.setEnabled(true);
            btnSkill1.setText("<html>Mac Attack<html>");
        }
        
        //Rex Skill 2 Cooldown
        if (activeCharacter == rex && rex.skill2Cooldown > 0) {
            btnSkill2.setEnabled(false);
            btnSkill2.setText("<html>Money Bribe<br>(" + rex.skill2Cooldown + ")<html>");
        } else if (activeCharacter == rex && rex.skill1Cooldown <= 0) {
            btnSkill2.setEnabled(true);
            btnSkill2.setText("Money Bribe");
        }                
        
        //Arth Skill 1 Cooldown
        if (activeCharacter == arth && arth.skill1Cooldown > 0) {
            btnSkill1.setEnabled(false);
            btnSkill1.setText("<html>Scolio<br>Attack<br>(" + arth.skill1Cooldown + ")<html>");
        } else if (activeCharacter == arth && arth.skill1Cooldown <= 0) {
            btnSkill1.setEnabled(true);
            btnSkill1.setText("Scolio Attack");
        }
        
        //Arth Skill2 Cooldown
        if (activeCharacter == arth && arth.skill2Cooldown > 0) {
            btnSkill2.setEnabled(false);
            btnSkill2.setText("<html>HackerMan<br>(" + arth.skill2Cooldown + ")<html>");
        } else if (arth.skill1Cooldown <= 0 && activeCharacter == arth) {
            btnSkill2.setEnabled(true);
            btnSkill2.setText("HackerMan");
        }
        
        if (arth.turnCount > 0) {
            arth.skill2(enemy);
            arth.turnCount -= 1;          
        } else if (arth.turnCount <= 0) {
            arth.hackerMan = false;
            arth.turnCount = 0;
        }
        
        //Aaron Skill1 Cooldown
        if (activeCharacter == aaron && aaron.skill1Cooldown > 0) {
            btnSkill1.setEnabled(false);
            btnSkill1.setText("<html>Instant Sleep<br>" + aaron.skill1Cooldown+ "<html>");
        } else if (aaron.skill1Cooldown <= 0 && activeCharacter == aaron) {
            btnSkill1.setEnabled(true);
            btnSkill1.setText("Spread Curse");
        }
        
        if (aaron.instantSleepTurnCount > 0) {
            aaron.skill1();
            aaron.instantSleepTurnCount -= 1;
        } else if (aaron.instantSleepTurnCount <= 0) {
            aaron.instantSleep = false;
            aaron.instantSleepTurnCount = 0;
        }
        
        //Aaron Skill2 Cooldown
        if (activeCharacter == aaron && aaron.skill2Cooldown > 0) {
            btnSkill2.setEnabled(false);
            btnSkill2.setText("<html>Spread Curse<br>"+aaron.skill2Cooldown+ "<html>");
        } else if (activeCharacter == aaron && aaron.skill2Cooldown <= 0) {
            btnSkill2.setEnabled(true);
            btnSkill2.setText("<html>Spread Curse<html>");
        }
        
        if (aaron.spreadCurseTurnCount > 0) {
            aaron.skill2(enemy);
            aaron.spreadCurseTurnCount -= 1;
        } else if(aaron.spreadCurseTurnCount <= 0) {
            aaron.spreadCurse = false;
            aaron.spreadCurseTurnCount = 0;
        }
    }

    private void enemyTakeTurn(){
        unlockCharacter();
        int randomMove = (int)(Math.random()*1+1);
        
        switch (randomMove) {
            
            case 1:
                enemy.basicAttack(activeCharacter);
                break;
                
            case 2:
                enemy.dodge();
                break;
                
            case 3:
                enemy.skill1(activeCharacter);
                break;
                
            case 4:
                enemy.skill2(activeCharacter);
                break;
                
                
            default:
                throw new AssertionError();
        }
        
        checkActiveCharacterHp();
        System.out.println("In enemyTurn: "+worldLevel);
    }
    
    public void cooldownHandler(){
        rex.skill1Cooldown -= 1;
        rex.skill2Cooldown -= 1;
        arth.skill1Cooldown -= 1;
        arth.skill2Cooldown -= 1;
        aaron.skill1Cooldown -= 1;
        aaron.skill2Cooldown -= 1;
        
        if (rex.skill1Cooldown <= 0) {
            rex.skill1Cooldown = 0;
        }
        if (rex.skill2Cooldown <= 0) {
            rex.skill2Cooldown = 0;
        }        
        if (arth.skill1Cooldown <= 0) {
            arth.skill1Cooldown = 0;
        }
        if (arth.skill2Cooldown <= 0) {
            arth.skill2Cooldown = 0;
        }
        if (aaron.skill1Cooldown <= 0) {
            aaron.skill1Cooldown = 0;
        }        
        if (aaron.skill2Cooldown <= 0) {
            aaron.skill2Cooldown = 0;
        }               
    }
    
    private int basicAttackDamageDealt(){
        int critChance = (int)(Math.random()*80+1);
        if (critChance < activeCharacter.critRate) {
            return (int) (activeCharacter.baseAttack * (1 + activeCharacter.critDamage));
        }
        return activeCharacter.baseAttack;
    }
    

    public static void main(String args[]) {


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Inventory;
    private javax.swing.JPanel PanelBattleDoings;
    private javax.swing.JPanel PanelBattlemiscellaneous;
    private javax.swing.JPanel PanelEnemyInfo;
    private javax.swing.JPanel PanelPlayerInfo;
    private javax.swing.JButton Shop;
    private javax.swing.JButton btnAaron;
    private javax.swing.JButton btnArth;
    private javax.swing.JButton btnBasicAttack;
    private javax.swing.JButton btnDodge;
    private javax.swing.JButton btnRex;
    private javax.swing.JButton btnSkill1;
    private javax.swing.JButton btnSkill2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblActiveCharacter;
    private javax.swing.JLabel lblActiveCharacterHpAndMaxHp;
    private javax.swing.JLabel lblActiveCharacterManaAndMaxMana;
    private javax.swing.JLabel lblActiveCharacterXpCurrAndMax;
    private javax.swing.JLabel lblEnemyHpAndMaxHp;
    private javax.swing.JLabel lblEnemyNameandLevel;
    private javax.swing.JLabel lblFloorLevel;
    private javax.swing.JLabel lblPlayersLevel;
    private javax.swing.JLabel lblSkill2Icon;
    private javax.swing.JProgressBar pBarActiveCharacterHP;
    private javax.swing.JProgressBar pBarActiveCharacterMana;
    private javax.swing.JProgressBar pBarEnemyHp;
    private javax.swing.JFormattedTextField txtTotalDamage;
    // End of variables declaration//GEN-END:variables
}
