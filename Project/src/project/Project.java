package project;

import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Project {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Proje");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ANA MENU ETİKETLERİ
        JLabel label1 = new JLabel("ANA MENU");
        frame.add(label1);
        label1.setBounds(10, 10, 1000, 30);
        JLabel label2 = new JLabel("Öğrenci numarası : 202313171803     Adı Soyadı : Ali Barış Varlıca");
        frame.add(label2);
        label2.setBounds(10, 30, 1000, 30);
        JLabel label3 = new JLabel("Derse Kayıtlı Olduğu Öğretim Grubu (1. Öğretim)");
        frame.add(label3);
        label3.setBounds(10, 50, 1000, 30);
        //

        // ANA MENÜ BUTONLARI
        JButton button1 = new JButton("Sayı Grubu Algoritmaları");
        frame.add(button1);
        button1.setBounds(10, 100, 500, 30);
        button1.addActionListener((ActionEvent e) -> {

            JFrame sayiGrubuFrame = new JFrame("Sayi Grubu Algoritmaları");
            sayiGrubuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            sayiGrubuFrame.setSize(700, 500);

            JLabel sayiGrubuFrameLabel = new JLabel("Çalıştırmak istediğiniz sayı grubunun rakamını seçiniz:");
            sayiGrubuFrame.add(sayiGrubuFrameLabel);
            sayiGrubuFrameLabel.setBounds(10, 10, 500, 20);

            JButton sayiGrububutton1 = new JButton("1- Mükemmel Sayılar Listele ve Girdiğiniz Sayı Mükemmel Mi Göster");
            sayiGrubuFrame.add(sayiGrububutton1);
            sayiGrububutton1.setBounds(10, 30, 500, 20);
            sayiGrububutton1.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Mükemmel Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayının mükemmel sayı olup olmadığını yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int toplam = 0;
                        for (int i = 1; i <= girilenSayi / 2; i++) {
                            if (girilenSayi % i == 0) {
                                toplam += i;
                            }
                        }
                        if (toplam == girilenSayi) {
                            ciktiEkrani.setText("" + girilenSayi + " Sayisi bir mükemmel sayıdır.");
                        } else {
                            ciktiEkrani.setText("" + girilenSayi + " Sayisi bir mükemmel sayı değildir..");
                        }
                    }

                });

                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton2 = new JButton("2- Fibonacci Sayıları (a) Recursive olarak b) standart çalıştırma");
            sayiGrubuFrame.add(sayiGrububutton2);
            sayiGrububutton2.setBounds(10, 50, 500, 20);
            sayiGrububutton2.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Fibonacci Sayıları");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar fibonacci sayılarını yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton recursiveButton = new JButton("Recursive çalıştır");
                newFrame.add(recursiveButton);
                recursiveButton.setBounds(10, 50, 200, 20);

                JButton standartButton = new JButton("Standart çalıştır");
                newFrame.add(standartButton);
                standartButton.setBounds(10, 80, 200, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 100, 1920, 20);

                recursiveButton.addActionListener((ActionEvent recursive) -> {
                    if (recursive.getSource() == recursiveButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        String fibonacciSerisi = "Recursive Fibonacci Serisi: ";
                        class FibonacciCalculator {

                            int fibonacci(int n) {
                                if (n <= 1) {
                                    return n;
                                } else {
                                    return fibonacci(n - 1) + fibonacci(n - 2);
                                }
                            }
                        }
                        FibonacciCalculator calc = new FibonacciCalculator();
                        for (int i = 0; i <= girilenSayi; i++) {
                            fibonacciSerisi += calc.fibonacci(i) + " ";
                        }
                        ciktiEkrani.setText(fibonacciSerisi);
                    }
                });

                standartButton.addActionListener((ActionEvent standart) -> {
                    if (standart.getSource() == standartButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        String fibonacciSerisi = "Standart Fibonacci Serisi: ";
                        int n1 = 0, n2 = 1;
                        fibonacciSerisi += n1 + " " + n2 + " ";
                        for (int i = 2; i <= girilenSayi; i++) {
                            int n3 = n1 + n2;
                            fibonacciSerisi += n3 + " ";
                            n1 = n2;
                            n2 = n3;
                        }

                        ciktiEkrani.setText(fibonacciSerisi);
                    }

                });

                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton3 = new JButton("3- Armstrong sayısı");
            sayiGrubuFrame.add(sayiGrububutton3);
            sayiGrububutton3.setBounds(10, 70, 500, 20);
            sayiGrububutton3.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Armstrong Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayının bir armstrong sayısı olup olmadığını yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int sayiUzunlugu = String.valueOf(girilenSayi).length();
                        int toplam = 0;
                        int gecici = girilenSayi;

                        while (gecici != 0) {
                            int basamak = gecici % 10;
                            toplam += Math.pow(basamak, sayiUzunlugu);
                            gecici /= 10;
                        }
                        if (toplam == girilenSayi) {
                            ciktiEkrani.setText("" + girilenSayi + " Sayisi bir armstrong sayıdır.");
                        } else {
                            ciktiEkrani.setText("" + girilenSayi + " Sayisi bir armstrong sayı değildir..");
                        }
                    }

                });

                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton4 = new JButton("4- Tribonacci Sayılar");
            sayiGrubuFrame.add(sayiGrububutton4);
            sayiGrububutton4.setBounds(10, 90, 500, 20);
            sayiGrububutton4.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Tribonacci Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar tribonacci sayıları yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int tribonacci1 = 0;
                        int tribonacci2 = 0;
                        int tribonacci3 = 1;
                        String tribonacciSerisi = "1 ";
                        for (int i = 1; i <= girilenSayi; i++) {
                            int tribonacci = tribonacci1 + tribonacci2 + tribonacci3;
                            tribonacciSerisi += tribonacci + " ";
                            tribonacci1 = tribonacci2;
                            tribonacci2 = tribonacci3;
                            tribonacci3 = tribonacci;
                        }
                        ciktiEkrani.setText(tribonacciSerisi);
                    }
                });

                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton5 = new JButton("5- Palindrom Sayılar");
            sayiGrubuFrame.add(sayiGrububutton5);
            sayiGrububutton5.setBounds(10, 110, 500, 20);
            sayiGrububutton5.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Palindrom Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar palindrom sayıları yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 1800, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        ArrayList<Integer> palindromikSayilar = new ArrayList<>();
                        for (int i = 0; palindromikSayilar.size() < girilenSayi; i++) {
                            String numberString = String.valueOf(i);
                            int length = numberString.length();
                            boolean isPalindrome = true;
                            for (int j = 0; j < length / 2; j++) {
                                if (numberString.charAt(j) != numberString.charAt(length - j - 1)) {
                                    isPalindrome = false;
                                    break;
                                }
                            }
                            if (isPalindrome) {
                                palindromikSayilar.add(i);
                            }
                        }
                        String palindormikSayilarString = "";
                        for (int number : palindromikSayilar) {
                            palindormikSayilarString += number + " ";
                        }
                        ciktiEkrani.setText(palindormikSayilarString);
                    }
                });

                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton6 = new JButton("6- Cullen Sayıları");
            sayiGrubuFrame.add(sayiGrububutton6);
            sayiGrububutton6.setBounds(10, 130, 500, 20);
            sayiGrububutton6.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Cullen Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayının cullen sayısı dönüşümü yapılır.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int cullenSayisi = (int) Math.pow(2, girilenSayi) * girilenSayi + 1;
                        String cullenSayisiStr = String.valueOf(cullenSayisi);
                        ciktiEkrani.setText(cullenSayisiStr);
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton7 = new JButton("7- Lasa Sayısı");
            sayiGrubuFrame.add(sayiGrububutton7);
            sayiGrububutton7.setBounds(10, 150, 500, 20);
            sayiGrububutton7.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Lasa Sayısı");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar lasa sayısı yazdırır.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        String lasaSayilari = "Lasa Sayıları: ";
                        for (int i = 1; i <= girilenSayi; i++) {
                            int lasa = (int) Math.pow(2, i) * i - 1;
                            lasaSayilari += lasa + " ";
                        }
                        ciktiEkrani.setText(lasaSayilari);
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton8 = new JButton("8- Fermat sayıları");
            sayiGrubuFrame.add(sayiGrububutton8);
            sayiGrububutton8.setBounds(10, 170, 500, 20);
            sayiGrububutton8.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Fermat sayıları");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar fermat sayısı yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        String fermatSayilari = "Fermat Sayıları: ";
                        for (int i = 0; i < girilenSayi; i++) {
                            long fermat = (long) Math.pow(2, (long) Math.pow(2, i)) + 1;
                            fermatSayilari += fermat + " ";
                        }
                        ciktiEkrani.setText(fermatSayilari);
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton9 = new JButton("9- Dost Sayılar");
            sayiGrubuFrame.add(sayiGrububutton9);
            sayiGrububutton9.setBounds(10, 190, 500, 20);
            sayiGrububutton9.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Dost Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayıların dost sayı olup olmadığını kontrol eden program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JTextField InputField2 = new JTextField();
                newFrame.add(InputField2);
                InputField2.setBounds(10, 50, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 70, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 100, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int girilenSayi2 = Integer.parseInt(InputField2.getText());
                        int sum1 = 0;
                        for (int i = 1; i <= girilenSayi / 2; i++) {
                            if (girilenSayi % i == 0) {
                                sum1 += i;
                            }
                        }
                        int sum2 = 0;
                        for (int i = 1; i <= girilenSayi2 / 2; i++) {
                            if (girilenSayi2 % i == 0) {
                                sum2 += i;
                            }
                        }
                        if (sum1 == girilenSayi2 && sum2 == girilenSayi) {
                            ciktiEkrani.setText(girilenSayi + " ve " + girilenSayi2 + " dost sayılardır.");
                        } else {
                            ciktiEkrani.setText(girilenSayi + " ve " + girilenSayi2 + " dost sayı değildir.");
                        }
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton10 = new JButton("10- Zengin Sayılar");
            sayiGrubuFrame.add(sayiGrububutton10);
            sayiGrububutton10.setBounds(10, 210, 500, 20);
            sayiGrububutton10.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Zengin Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar zengin sayılar yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int sayac = 0;
                        int sayi = 12;
                        String zenginSayilar = "";
                        while (sayac < girilenSayi) {
                            int toplam = 0;
                            for (int i = 1; i <= sayi / 2; i++) {
                                if (sayi % i == 0) {
                                    toplam += i;
                                }
                            }
                            if (toplam > sayi) {
                                zenginSayilar += sayi + " ";
                                sayac++;
                            }
                            sayi++;
                        }
                        ciktiEkrani.setText(zenginSayilar);
                    }
                });

                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton11 = new JButton("11- Lucas Serisi");
            sayiGrubuFrame.add(sayiGrububutton11);
            sayiGrububutton11.setBounds(10, 230, 500, 20);
            sayiGrububutton11.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Lucas Serisi");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar lucas serisini yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        String lucasSerisi = "Lucas Serisi: ";
                        if (girilenSayi >= 1) {
                            int lucas1 = 2; // İlk Lucas sayısı
                            int lucas2 = 1; // İkinci Lucas sayısı
                            lucasSerisi += lucas1 + " ";
                            if (girilenSayi >= 2) {
                                lucasSerisi += lucas2 + " ";
                            }
                            for (int i = 3; i <= girilenSayi; i++) {
                                int nextLucas = lucas1 + lucas2;
                                lucasSerisi += nextLucas + " ";
                                lucas1 = lucas2;
                                lucas2 = nextLucas;
                            }
                        }
                        ciktiEkrani.setText(lucasSerisi);
                    }
                });

                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton12 = new JButton("12- Tetranacci Sayılar");
            sayiGrubuFrame.add(sayiGrububutton12);
            sayiGrububutton12.setBounds(10, 250, 500, 20);
            sayiGrububutton12.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Tetranacci Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar tetranacci sayıları yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        String tetranacciSerisi = "Tetranacci Serisi: ";

                        if (girilenSayi >= 1) {
                            int tetranacci1 = 0;
                            int tetranacci2 = 0;
                            int tetranacci3 = 0;
                            int tetranacci4 = 1;

                            tetranacciSerisi += tetranacci4 + " ";

                            for (int i = 2; i <= girilenSayi; i++) {
                                int nextTetranacci = tetranacci1 + tetranacci2 + tetranacci3 + tetranacci4;
                                tetranacciSerisi += nextTetranacci + " ";
                                tetranacci1 = tetranacci2;
                                tetranacci2 = tetranacci3;
                                tetranacci3 = tetranacci4;
                                tetranacci4 = nextTetranacci;
                            }
                        }

                        ciktiEkrani.setText(tetranacciSerisi);
                    }
                });

                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton13 = new JButton("13- İkiz Sayılar");
            sayiGrubuFrame.add(sayiGrububutton13);
            sayiGrububutton13.setBounds(10, 270, 500, 20);
            sayiGrububutton13.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("İkiz Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayıların ikiz asal olup olmadığını kontrol eden program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);
                
                JTextField InputField2 = new JTextField();
                newFrame.add(InputField2);
                InputField2.setBounds(10, 50, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 80, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 100, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int girilenSayi2 = Integer.parseInt(InputField2.getText());
                        boolean asalMi1 = true;
                        boolean asalMi2 = true;
                        for (int i = 2; i<girilenSayi; i++){
                            if (girilenSayi % i == 0){
                                asalMi1 = false;
                                break;
                            }
                        }
                        for (int i = 2; i<girilenSayi2; i++){
                            if (girilenSayi2 % i == 0){
                                asalMi2 = false;
                                break;
                            }
                        }
                        if (asalMi1 && asalMi2){
                            if(Math.abs(girilenSayi - girilenSayi2) == 2){
                            ciktiEkrani.setText("Sayılar ikiz asal.");
                            } else ciktiEkrani.setText("Sayılar ikiz asal değildir.");
                        }
                        else {
                            ciktiEkrani.setText("En az bir sayı asal değildir.");
                        }
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton14 = new JButton("14- Weodal Sayılar");
            sayiGrubuFrame.add(sayiGrububutton14);
            sayiGrububutton14.setBounds(10, 290, 500, 20);
            sayiGrububutton14.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Weodal Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar weodal sayıları yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        String weodallSerisi = "Weodall Serisi: ";
                        if (girilenSayi >= 1) {
                            int weodall1 = 1;
                            int weodall2 = 1;

                            weodallSerisi += weodall1 + " " + weodall2 + " ";

                            for (int i = 3; i <= girilenSayi; i++) {
                                int nextWeodall = 2 * weodall2 - weodall1 + 2;
                                weodallSerisi += nextWeodall + " ";
                                weodall1 = weodall2;
                                weodall2 = nextWeodall;
                            }
                        }
                        ciktiEkrani.setText(weodallSerisi);
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton15 = new JButton("15- Mersanne Sayılar");
            sayiGrubuFrame.add(sayiGrububutton15);
            sayiGrububutton15.setBounds(10, 310, 500, 20);
            sayiGrububutton15.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Mersanne Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayı adedi kadar Mersanne sayıları yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        String mersenneSerisi = "Mersenne Sayıları: ";
                        if (girilenSayi >= 2) {
                            for (int i = 2; i <= girilenSayi; i++) {
                                int mersenne = (int) Math.pow(2, i) - 1;
                                mersenneSerisi += mersenne + " ";
                            }
                        }
                        ciktiEkrani.setText(mersenneSerisi);
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton16 = new JButton("16- Harshad Sayılar");
            sayiGrubuFrame.add(sayiGrububutton16);
            sayiGrububutton16.setBounds(10, 330, 500, 20);
            sayiGrububutton16.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Harshad Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayının Harshad sayısı olup olmadığını yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int sumOfDigits = 0;
                        int temp = girilenSayi;
                        while (temp > 0) {
                            sumOfDigits += temp % 10;
                            temp /= 10;
                        }
                        if (girilenSayi % sumOfDigits == 0) {
                            ciktiEkrani.setText(girilenSayi + " bir Harshad sayısıdır.");
                        } else {
                            ciktiEkrani.setText(girilenSayi + " bir Harshad sayısı değildir.");
                        }
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton17 = new JButton("17- Cyclic (Döngüsel Sayılar)");
            sayiGrubuFrame.add(sayiGrububutton17);
            sayiGrububutton17.setBounds(10, 350, 500, 20);
            sayiGrububutton17.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Cyclic (Döngüsel Sayılar)");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayının bir cyclic sayı olup olmadığını yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        boolean isCyclic = true;
                        String original = Integer.toString(girilenSayi);
                        for (int i = 1; i <= original.length(); i++) {
                            int multiple = girilenSayi * i;
                            String multipleStr = Integer.toString(multiple);
                            if (multipleStr.length() != original.length()) {
                                isCyclic = false;
                                break;
                            }
                            char[] originalChars = original.toCharArray();
                            char[] multipleChars = multipleStr.toCharArray();
                            Arrays.sort(originalChars);
                            Arrays.sort(multipleChars);
                            if (!Arrays.equals(originalChars, multipleChars)) {
                                isCyclic = false;
                                break;
                            }
                        }
                        if (isCyclic) {
                            ciktiEkrani.setText(girilenSayi + " bir döngüsel (cyclic) sayıdır.");
                        } else {
                            ciktiEkrani.setText(girilenSayi + " bir döngüsel (cyclic) sayı değildir.");
                        }
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton18 = new JButton("18- Tav Sayılar");
            sayiGrubuFrame.add(sayiGrububutton18);
            sayiGrububutton18.setBounds(10, 370, 500, 20);
            sayiGrububutton18.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Tav Sayılar");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen sayının bir tau sayısı olup olmadığını yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int sayac = 0;
                        for (int i = 1; i <= girilenSayi; i++) {
                            if (girilenSayi % i == 0) {
                                sayac++;
                            }
                        }
                        if (girilenSayi % sayac == 0) {
                            ciktiEkrani.setText(girilenSayi + " sayısı bir tau sayısıdır.");
                        } else {
                            ciktiEkrani.setText(girilenSayi + " sayısı bir tau sayısı değildir.");
                        }
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton19 = new JButton("19- Bağdaşık Sayılar (Amicable)");
            sayiGrubuFrame.add(sayiGrububutton19);
            sayiGrububutton19.setBounds(10, 390, 500, 20);
            sayiGrububutton19.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("Bağdaşık Sayılar (Amicable)");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen iki sayının bağdaşık sayı olup olmadığını yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JTextField InputField2 = new JTextField();
                newFrame.add(InputField2);
                InputField2.setBounds(10, 50, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 80, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 100, 500, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        int girilenSayi2 = Integer.parseInt(InputField2.getText());
                        int count = 0;
                        for (int i = 1; i <= girilenSayi; i++) {
                            if (girilenSayi % i == 0) {
                                count++;
                            }
                        }
                        int dizi[] = new int[count];
                        int a = 0;
                        int sayac = 0;
                        for (int i = 1; i < girilenSayi; i++) {
                            if (girilenSayi % i == 0) {
                                dizi[a] = i;
                                a++;
                                sayac += i;
                            }
                        }
                        if (girilenSayi2 == sayac) {
                            ciktiEkrani.setText(girilenSayi + " " + girilenSayi2 + " sayıları bağdaşık sayılardır.");

                        } else {
                            ciktiEkrani.setText(girilenSayi + " " + girilenSayi2 + " sayıları bağdaşık sayılar değildir.");
                        }
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            JButton sayiGrububutton20 = new JButton("20- 6174 sayısı");
            sayiGrubuFrame.add(sayiGrububutton20);
            sayiGrububutton20.setBounds(10, 410, 500, 20);
            sayiGrububutton20.addActionListener((ActionEvent event) -> {
                JFrame newFrame = new JFrame("6174 sayısı");
                newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                newFrame.setSize(500, 200);

                JLabel programLabel = new JLabel("Girilen iki sayının bağdaşık sayı olup olmadığını yazdıran program.");
                newFrame.add(programLabel);
                programLabel.setBounds(10, 5, 1000, 30);

                JTextField InputField = new JTextField();
                newFrame.add(InputField);
                InputField.setBounds(10, 30, 300, 20);

                JButton onaylaButton = new JButton("Onayla");
                newFrame.add(onaylaButton);
                onaylaButton.setBounds(10, 50, 100, 20);

                JLabel ciktiEkrani = new JLabel();
                newFrame.add(ciktiEkrani);
                ciktiEkrani.setBounds(10, 80, 1800, 20);

                onaylaButton.addActionListener((ActionEvent onayla) -> {
                    if (onayla.getSource() == onaylaButton) {
                        int girilenSayi = Integer.parseInt(InputField.getText());
                        String steps = "";
                        while (girilenSayi != 6174) {
                            int[] digits = new int[4];
                            int temp = girilenSayi;
                            for (int i = 3; i >= 0; i--) {
                                digits[i] = temp % 10;
                                temp /= 10;
                            }
                            Arrays.sort(digits);
                            int ascending = 0;
                            int descending = 0;
                            for (int i = 0; i < 4; i++) {
                                ascending = ascending * 10 + digits[i];
                                descending = descending * 10 + digits[3 - i];
                            }
                            girilenSayi = descending - ascending;
                            steps += "Descending: " + descending + ", Ascending: " + ascending + ", Difference: " + girilenSayi + "\n";
                            if (girilenSayi == 0) {
                                steps += "Sayı 0'a ulaştı, 6174'e ulaşamaz.\n";
                                break;
                            }
                        }
                        ciktiEkrani.setText(steps);
                    }
                });
                newFrame.setLayout(null);
                newFrame.setVisible(true);
            });

            sayiGrubuFrame.setLayout(null);
            sayiGrubuFrame.setVisible(true);

        }
        );

        // BUTON1 SONU
        JButton button2 = new JButton("Sıralama Algoritmaları");
        frame.add(button2);
        button2.setBounds(10, 150, 500, 30);
        button2.addActionListener(
                (ActionEvent e) -> {
                    JFrame siralamaAlgoritmalariFrame = new JFrame("Sıralama Algoritmaları");
                    siralamaAlgoritmalariFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    siralamaAlgoritmalariFrame.setSize(700, 500);

                    JLabel siralamaAlgoritmalariFrameLabel = new JLabel("Çalıştırmak istediğiniz sıralama algoritmasının rakamını seçiniz:");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalariFrameLabel);
                    siralamaAlgoritmalariFrameLabel.setBounds(10, 10, 500, 30);

                    JButton siralamaAlgoritmalaributton1 = new JButton("1- Insertion Sort (Eklemeli Sıralama )");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton1);
                    siralamaAlgoritmalaributton1.setBounds(10, 30, 500, 20);
                    siralamaAlgoritmalaributton1.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Insertion Sort (Eklemeli Sıralama )");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri insertion sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                for (int i = 1; i < girilenSayilar.length; i++) {
                                    int key = girilenSayilar[i];
                                    int j = i - 1;
                                    while (j >= 0 && girilenSayilar[j] > key) {
                                        girilenSayilar[j + 1] = girilenSayilar[j];
                                        j = j - 1;
                                    }
                                    girilenSayilar[j + 1] = key;
                                }
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton2 = new JButton("2- Selection Sort (Seçmeli Sıralama)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton2);
                    siralamaAlgoritmalaributton2.setBounds(10, 50, 500, 20);
                    siralamaAlgoritmalaributton2.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Selection Sort (Seçmeli Sıralama");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri selection sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                for (int i = 0; i < girilenSayilar.length - 1; i++) {
                                    int minIndex = i;
                                    for (int j = i + 1; j < girilenSayilar.length; j++) {
                                        if (girilenSayilar[j] < girilenSayilar[minIndex]) {
                                            minIndex = j;
                                        }
                                    }
                                    int temp = girilenSayilar[minIndex];
                                    girilenSayilar[minIndex] = girilenSayilar[i];
                                    girilenSayilar[i] = temp;
                                }
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton3 = new JButton("3- Bubble Sort (Kabarcık/Baloncuk sıralama)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton3);
                    siralamaAlgoritmalaributton3.setBounds(10, 70, 500, 20);
                    siralamaAlgoritmalaributton3.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Selection Sort (Seçmeli Sıralama");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri bubble sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                for (int i = 0; i < girilenSayilar.length - 1; i++) {
                                    for (int j = 0; j < girilenSayilar.length - 1 - i; j++) {
                                        if (girilenSayilar[j] > girilenSayilar[j + 1]) {
                                            int temp = girilenSayilar[j];
                                            girilenSayilar[j] = girilenSayilar[j + 1];
                                            girilenSayilar[j + 1] = temp;
                                        }
                                    }
                                }
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton4 = new JButton("4- Divide and Conquer Sort (Böl ve Ayıkla Algoritması)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton4);
                    siralamaAlgoritmalaributton4.setBounds(10, 90, 500, 20);
                    siralamaAlgoritmalaributton4.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Selection Sort (Seçmeli Sıralama");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri divide and conquer sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {

                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                int baslangicIndeksi = 0;
                                int bitisIndeksi = girilenSayilar.length - 1;
                                SortingAlgorithms.divideAndConquer(girilenSayilar, baslangicIndeksi, bitisIndeksi);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });

                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton5 = new JButton("5- Shell Sort");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton5);
                    siralamaAlgoritmalaributton5.setBounds(10, 110, 500, 20);
                    siralamaAlgoritmalaributton5.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Shell Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Shell Sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                int n = girilenSayilar.length;
                                for (int gap = n / 2; gap > 0; gap /= 2) {
                                    for (int i = gap; i < n; i++) {
                                        int temp = girilenSayilar[i];
                                        int j;
                                        for (j = i; j >= gap && girilenSayilar[j - gap] > temp; j -= gap) {
                                            girilenSayilar[j] = girilenSayilar[j - gap];
                                        }
                                        girilenSayilar[j] = temp;
                                    }
                                }
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton6 = new JButton("6- Merge Sort");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton6);
                    siralamaAlgoritmalaributton6.setBounds(10, 130, 500, 20);
                    siralamaAlgoritmalaributton6.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Merge Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Merge Sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.mergeSort(girilenSayilar, 0, girilenSayilar.length - 1);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton7 = new JButton("7- Quick Sort");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton7);
                    siralamaAlgoritmalaributton7.setBounds(10, 150, 500, 20);
                    siralamaAlgoritmalaributton7.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Quick Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Quick Sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.quickSort(girilenSayilar, 0, girilenSayilar.length - 1);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton8 = new JButton("8- Quick Sort3");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton8);
                    siralamaAlgoritmalaributton8.setBounds(10, 170, 500, 20);
                    siralamaAlgoritmalaributton8.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Quick Sort3");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Quick Sort3 kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.quickSort3(girilenSayilar, 0, girilenSayilar.length - 1);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton9 = new JButton("9- Heap Sort (Yığınlama)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton9);
                    siralamaAlgoritmalaributton9.setBounds(10, 190, 500, 20);
                    siralamaAlgoritmalaributton9.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Heap Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Heap Sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms sorter = new SortingAlgorithms();
                                sorter.heapSort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton10 = new JButton("10- Taban Sıralama (Radix)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton10);
                    siralamaAlgoritmalaributton10.setBounds(10, 210, 500, 20);
                    siralamaAlgoritmalaributton10.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Taban Sıralama");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Taban Sıralama kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms sorter = new SortingAlgorithms();
                                sorter.radixSort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton11 = new JButton("11- Shaker Sort (Sallama sıralama)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton11);
                    siralamaAlgoritmalaributton11.setBounds(10, 230, 500, 20);
                    siralamaAlgoritmalaributton11.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Shaker Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Shaker Sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms sorter = new SortingAlgorithms();
                                sorter.shakerSort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton12 = new JButton("12- Rastgele sort(Random sort)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton12);
                    siralamaAlgoritmalaributton12.setBounds(10, 250, 500, 20);
                    siralamaAlgoritmalaributton12.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Rastgele Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Rastgele sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.bogoSort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton13 = new JButton("13- Lucky Sort (Şanslı Sıralama)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton13);
                    siralamaAlgoritmalaributton13.setBounds(10, 270, 500, 20);
                    siralamaAlgoritmalaributton13.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Lucky Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Lucky sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.luckySort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton14 = new JButton("14- Serseri Sort (Stooge)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton14);
                    siralamaAlgoritmalaributton14.setBounds(10, 290, 500, 20);
                    siralamaAlgoritmalaributton14.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Serseri Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Serseri sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.serseriSort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton15 = new JButton("15- Şimşek (Flash Sort)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton15);
                    siralamaAlgoritmalaributton15.setBounds(10, 310, 500, 20);
                    siralamaAlgoritmalaributton15.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Şimşek Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Şimşek sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.flashSort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton16 = new JButton("16- Comb Sort (Tarak sort)");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton16);
                    siralamaAlgoritmalaributton16.setBounds(10, 330, 500, 20);
                    siralamaAlgoritmalaributton16.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Comb Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Comb sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.combSort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton17 = new JButton("17- Gnome Sort");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton17);
                    siralamaAlgoritmalaributton17.setBounds(10, 350, 500, 20);
                    siralamaAlgoritmalaributton17.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Gnome Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Gnome sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.gnomeSort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton18 = new JButton("18- Permütasyon Sort");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton18);
                    siralamaAlgoritmalaributton18.setBounds(10, 370, 500, 20);
                    siralamaAlgoritmalaributton18.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Permütasyon Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Permütasyon sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                int girilenSayi1 = Integer.parseInt(InputField1.getText());
                                int girilenSayi2 = Integer.parseInt(InputField2.getText());
                                int girilenSayi3 = Integer.parseInt(InputField3.getText());
                                int girilenSayi4 = Integer.parseInt(InputField4.getText());
                                int girilenSayi5 = Integer.parseInt(InputField5.getText());
                                int[] girilenSayilar = {girilenSayi1, girilenSayi2, girilenSayi3, girilenSayi4, girilenSayi5};
                                SortingAlgorithms.permutationSort(girilenSayilar);
                                StringBuilder sortedNumbers = new StringBuilder();
                                for (int num : girilenSayilar) {
                                    sortedNumbers.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedNumbers.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton19 = new JButton("19- Strand Sort");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton19);
                    siralamaAlgoritmalaributton19.setBounds(10, 390, 500, 20);
                    siralamaAlgoritmalaributton19.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Strand Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Strand sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                List<Integer> girilenSayilar = new ArrayList<>();
                                girilenSayilar.add(Integer.parseInt(InputField1.getText()));
                                girilenSayilar.add(Integer.parseInt(InputField2.getText()));
                                girilenSayilar.add(Integer.parseInt(InputField3.getText()));
                                girilenSayilar.add(Integer.parseInt(InputField4.getText()));
                                girilenSayilar.add(Integer.parseInt(InputField5.getText()));
                                List<Integer> sortedNumbers = SortingAlgorithms.strandSort(girilenSayilar);

                                StringBuilder sortedString = new StringBuilder();
                                for (int num : sortedNumbers) {
                                    sortedString.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedString.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton siralamaAlgoritmalaributton20 = new JButton("20- Kova Sort");
                    siralamaAlgoritmalariFrame.add(siralamaAlgoritmalaributton20);
                    siralamaAlgoritmalaributton20.setBounds(10, 410, 500, 20);
                    siralamaAlgoritmalaributton20.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Kova Sort");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(1000, 1000);

                        JLabel programLabel = new JLabel("Girilen verileri Kova sort kullanarak sıralayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField1 = new JTextField();
                        newFrame.add(InputField1);
                        InputField1.setBounds(10, 30, 300, 20);

                        JTextField InputField2 = new JTextField();
                        newFrame.add(InputField2);
                        InputField2.setBounds(10, 50, 300, 20);

                        JTextField InputField3 = new JTextField();
                        newFrame.add(InputField3);
                        InputField3.setBounds(10, 70, 300, 20);

                        JTextField InputField4 = new JTextField();
                        newFrame.add(InputField4);
                        InputField4.setBounds(10, 90, 300, 20);

                        JTextField InputField5 = new JTextField();
                        newFrame.add(InputField5);
                        InputField5.setBounds(10, 110, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 140, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 170, 1800, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                List<Integer> girilenSayilar = new ArrayList<>();
                                girilenSayilar.add(Integer.parseInt(InputField1.getText()));
                                girilenSayilar.add(Integer.parseInt(InputField2.getText()));
                                girilenSayilar.add(Integer.parseInt(InputField3.getText()));
                                girilenSayilar.add(Integer.parseInt(InputField4.getText()));
                                girilenSayilar.add(Integer.parseInt(InputField5.getText()));
                                List<Integer> sortedNumbers = SortingAlgorithms.bucketSort(girilenSayilar);
                                StringBuilder sortedString = new StringBuilder();
                                for (int num : sortedNumbers) {
                                    sortedString.append(num).append(", ");
                                }
                                ciktiEkrani.setText("Sıralanmış Sayılar: " + sortedString.toString());
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    siralamaAlgoritmalariFrame.setLayout(null);
                    siralamaAlgoritmalariFrame.setVisible(true);
                }
        );

        // BUTON 2 SONU
        JButton button3 = new JButton("Arama Algoritmaları");
        frame.add(button3);
        button3.setBounds(10, 200, 500, 30);
        button3.addActionListener(
                (ActionEvent e) -> {
                    JFrame aramaAlgoritmalariFrame = new JFrame("Arama Algoritmaları");
                    aramaAlgoritmalariFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    aramaAlgoritmalariFrame.setSize(700, 450);

                    JLabel siralamaAlgoritmalariFrameLabel = new JLabel("Çalıştırmak istediğiniz arama algoritmasının rakamını seçiniz:");
                    aramaAlgoritmalariFrame.add(siralamaAlgoritmalariFrameLabel);
                    siralamaAlgoritmalariFrameLabel.setBounds(10, 10, 500, 20);

                    JButton aramaAlgoritmalaributton1 = new JButton("1- Doğrusal Arama (Linear Search)");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton1);
                    aramaAlgoritmalaributton1.setBounds(10, 30, 500, 20);
                    aramaAlgoritmalaributton1.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Doğrusal Arama");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(500, 200);

                        JLabel programLabel = new JLabel("Doğrusal arama kullanarak girilen sayıyı arayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField = new JTextField();
                        newFrame.add(InputField);
                        InputField.setBounds(10, 30, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 50, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 80, 500, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                try {
                                    int girilenSayi = Integer.parseInt(InputField.getText());
                                    int[] veriSeti = SearchingAlgorithms.rastgeleVeriOlustur(10);
                                    int arananSayi = new Random().nextInt(100) + 1;
                                    System.out.println("" + arananSayi);
                                    boolean bulundu = SearchingAlgorithms.linearSearch(veriSeti, girilenSayi);
                                    StringBuilder diziStr = new StringBuilder("Dizi: ");
                                    for (int num : veriSeti) {
                                        diziStr.append(num).append(" ");
                                    }
                                    diziStr.append("\nAranan Sayı: ").append(girilenSayi);
                                    if (bulundu) {
                                        diziStr.append(" Sonuç: ").append(girilenSayi).append(" bulundu.");
                                    } else {
                                        diziStr.append(" Sonuç: ").append(girilenSayi).append(" bulunamadı.");
                                    }
                                    ciktiEkrani.setText(diziStr.toString());
                                } catch (NumberFormatException e1) {
                                    ciktiEkrani.setText("Lütfen geçerli bir sayı girin.");
                                }
                            }
                        });

                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton aramaAlgoritmalaributton2 = new JButton("2- İkili arama (binary search)");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton2);
                    aramaAlgoritmalaributton2.setBounds(10, 50, 500, 20);
                    aramaAlgoritmalaributton2.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("İkili arama");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(500, 200);

                        JLabel programLabel = new JLabel("İkili arama kullanarak girilen sayıyı arayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField = new JTextField();
                        newFrame.add(InputField);
                        InputField.setBounds(10, 30, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 50, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 80, 500, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                try {
                                    int girilenSayi = Integer.parseInt(InputField.getText());
                                    int[] veriSeti = SearchingAlgorithms.rastgeleVeriOlustur(10);
                                    Arrays.sort(veriSeti);  // Binary search için diziyi sıralıyoruz
                                    boolean bulundu = SearchingAlgorithms.binarySearch(veriSeti, girilenSayi);
                                    StringBuilder diziStr = new StringBuilder("Dizi: ");
                                    for (int num : veriSeti) {
                                        diziStr.append(num).append(" ");
                                    }
                                    diziStr.append("\nAranan Sayı: ").append(girilenSayi);
                                    if (bulundu) {
                                        diziStr.append(" Sonuç: ").append(girilenSayi).append(" bulundu.");
                                    } else {
                                        diziStr.append(" Sonuç: ").append(girilenSayi).append(" bulunamadı.");
                                    }
                                    ciktiEkrani.setText(diziStr.toString());
                                } catch (NumberFormatException e1) {
                                    ciktiEkrani.setText("Lütfen geçerli bir sayı girin.");
                                }
                            }
                        });

                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton aramaAlgoritmalaributton3 = new JButton("3- Interpolasyon Araması (Ara değer araması, Interpolation Search)");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton3);
                    aramaAlgoritmalaributton3.setBounds(10, 70, 500, 20);
                    aramaAlgoritmalaributton3.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Interpolasyon Araması");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(500, 200);

                        JLabel programLabel = new JLabel("Interpolasyon araması kullanarak girilen sayıyı arayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField = new JTextField();
                        newFrame.add(InputField);
                        InputField.setBounds(10, 30, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 50, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 80, 500, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                try {
                                    int girilenSayi = Integer.parseInt(InputField.getText());
                                    int[] veriSeti = SearchingAlgorithms.rastgeleVeriOlustur(10);
                                    Arrays.sort(veriSeti);
                                    boolean bulundu = SearchingAlgorithms.interpolationSearch(veriSeti, girilenSayi);
                                    StringBuilder diziStr = new StringBuilder("Dizi: ");
                                    for (int num : veriSeti) {
                                        diziStr.append(num).append(" ");
                                    }
                                    diziStr.append("\nAranan Sayı: ").append(girilenSayi);
                                    if (bulundu) {
                                        diziStr.append(" Sonuç: ").append(girilenSayi).append(" bulundu.");
                                    } else {
                                        diziStr.append(" Sonuç: ").append(girilenSayi).append(" bulunamadı.");
                                    }
                                    ciktiEkrani.setText(diziStr.toString());
                                } catch (NumberFormatException e1) {
                                    ciktiEkrani.setText("Lütfen geçerli bir sayı girin.");
                                }
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton aramaAlgoritmalaributton4 = new JButton("4- Şekiller (graflar (Graphs) ) üzerinde çalışan algoritmalar");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton4);
                    aramaAlgoritmalaributton4.setBounds(10, 90, 500, 20);

                    JButton aramaAlgoritmalaributton5 = new JButton("5- Sabit Maliyetli Arama (Uniform Cost Search)");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton5);
                    aramaAlgoritmalaributton5.setBounds(10, 110, 500, 20);
                    aramaAlgoritmalaributton5.addActionListener((ActionEvent event) -> {
                        JFrame newFrame = new JFrame("Sabit Maliyetli");
                        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        newFrame.setSize(500, 200);

                        JLabel programLabel = new JLabel("Sabit Maliyetli arama kullanarak girilen sayıyı arayan program.");
                        newFrame.add(programLabel);
                        programLabel.setBounds(10, 5, 1000, 30);

                        JTextField InputField = new JTextField();
                        newFrame.add(InputField);
                        InputField.setBounds(10, 30, 300, 20);

                        JButton onaylaButton = new JButton("Onayla");
                        newFrame.add(onaylaButton);
                        onaylaButton.setBounds(10, 50, 100, 20);

                        JLabel ciktiEkrani = new JLabel();
                        newFrame.add(ciktiEkrani);
                        ciktiEkrani.setBounds(10, 80, 500, 20);

                        onaylaButton.addActionListener((ActionEvent onayla) -> {
                            if (onayla.getSource() == onaylaButton) {
                                try {
                                    int girilenSayi = Integer.parseInt(InputField.getText());
                                    int[] veriSeti = SearchingAlgorithms.rastgeleVeriOlustur(10);
                                    Map<Integer, Integer> veriMap = SearchingAlgorithms.arrayToHashMap(veriSeti);

                                    boolean bulundu = SearchingAlgorithms.constantTimeSearch(veriMap, girilenSayi);

                                    StringBuilder diziStr = new StringBuilder("Dizi: ");
                                    for (int num : veriSeti) {
                                        diziStr.append(num).append(" ");
                                    }
                                    diziStr.append("\nAranan Sayı: ").append(girilenSayi);
                                    if (bulundu) {
                                        diziStr.append(" Sonuç: ").append(girilenSayi).append(" bulundu.");
                                    } else {
                                        diziStr.append(" Sonuç: ").append(girilenSayi).append(" bulunamadı.");
                                    }
                                    ciktiEkrani.setText(diziStr.toString());
                                } catch (NumberFormatException e1) {
                                    ciktiEkrani.setText("Lütfen geçerli bir sayı girin.");
                                }
                            }
                        });
                        newFrame.setLayout(null);
                        newFrame.setVisible(true);
                    });

                    JButton aramaAlgoritmalaributton6 = new JButton("6- Floyd Warshall algoritması");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton6);
                    aramaAlgoritmalaributton6.setBounds(10, 130, 500, 20);

                    JButton aramaAlgoritmalaributton7 = new JButton("7- Prim’s Algoritması");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton7);
                    aramaAlgoritmalaributton7.setBounds(10, 150, 500, 20);

                    JButton aramaAlgoritmalaributton8 = new JButton("8- Kruskal Algoritması");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton8);
                    aramaAlgoritmalaributton8.setBounds(10, 170, 500, 20);

                    JButton aramaAlgoritmalaributton9 = new JButton("9- Dijkstra Algoritması");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton9);
                    aramaAlgoritmalaributton9.setBounds(10, 190, 500, 20);

                    JButton aramaAlgoritmalaributton10 = new JButton("10- Bellman Ford Algoritması");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton10);
                    aramaAlgoritmalaributton10.setBounds(10, 210, 500, 20);

                    JButton aramaAlgoritmalaributton11 = new JButton("11- İkili arama ağacı (Binary Search Tree)");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton11);
                    aramaAlgoritmalaributton11.setBounds(10, 230, 500, 20);

                    JButton aramaAlgoritmalaributton12 = new JButton("12- Prüfer dizilimi");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton12);
                    aramaAlgoritmalaributton12.setBounds(10, 250, 500, 20);

                    JButton aramaAlgoritmalaributton13 = new JButton("13- Metin arama algoritmaları ((string) arayan algoritmalar)");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton13);
                    aramaAlgoritmalaributton13.setBounds(10, 270, 500, 20);

                    JButton aramaAlgoritmalaributton14 = new JButton("14- Horspool Arama Algoritması");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton14);
                    aramaAlgoritmalaributton14.setBounds(10, 290, 500, 20);

                    JButton aramaAlgoritmalaributton15 = new JButton("15- Kaba Kuvvet Arama Algoritması (BruteForceTextSearch, LinearTextSearch)");
                    aramaAlgoritmalariFrame.add(aramaAlgoritmalaributton15);
                    aramaAlgoritmalaributton15.setBounds(10, 310, 500, 20);

                    aramaAlgoritmalariFrame.setLayout(null);
                    aramaAlgoritmalariFrame.setVisible(true);
                }
        );

        // BUTON 3 SONU
        frame.setLayout(
                null);
        frame.setVisible(
                true);

    }
}
