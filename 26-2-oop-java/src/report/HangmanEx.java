package report;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HangmanEx extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	String[] words = new String[201];
	int[] checked = new int[201]; // 나왔던 단어 체크하는 배열
	int word_length; // 단어의 길이
	int guessNum; // 맞추는 횟수 (10번만에 맞추는지 8번만에 맞추는지)
	int level; // 게임 난이도
	char[] word1 = new char[12]; // 프로그램 안에서 돌아가는 char
	String[] slevel = { "Easy", "Medium", "Hard" }; // 난이도
	String[] word2 = new String[12]; // 화면에 출력할 String
	String check_word;
	double wins;
	double looses;
	double winningProsentige;
	JButton a = new JButton("A");
	JButton b = new JButton("B");
	JButton c = new JButton("C");
	JButton d = new JButton("D");
	JButton e = new JButton("E");
	JButton f = new JButton("F");
	JButton g = new JButton("G");
	JButton h = new JButton("H");
	JButton i = new JButton("I");
	JButton j = new JButton("J");
	JButton k = new JButton("K");
	JButton l = new JButton("L");
	JButton m = new JButton("M");
	JButton n = new JButton("N");
	JButton o = new JButton("O");
	JButton p = new JButton("P");
	JButton q = new JButton("Q");
	JButton r = new JButton("R");
	JButton s = new JButton("S");
	JButton t = new JButton("T");
	JButton u = new JButton("U");
	JButton v = new JButton("V");
	JButton w = new JButton("W");
	JButton x = new JButton("X");
	JButton y = new JButton("Y");
	JButton z = new JButton("Z");
	JButton begin = new JButton("BEGIN");
	JButton easy = new JButton("EASY");
	JButton medium = new JButton("MEDIUM");
	JButton hard = new JButton("HARD");
	JLabel text = new JLabel("Skill level: ", JLabel.LEFT); // 레벨 레이블로 띄우기

	JPanel displayTOP = new JPanel();
	JPanel display1 = new JPanel();
	JPanel display2 = new JPanel();

	Font normalFont = new Font("Arial", Font.BOLD, 16);
	Font warningFont = new Font("Arial", Font.BOLD, 20);

	public HangmanEx() {
		setTitle("행맨 게임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(850, 700);
		setVisible(true);
	}

	public void init() {
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		e.addActionListener(this);
		f.addActionListener(this);
		g.addActionListener(this);
		h.addActionListener(this);
		i.addActionListener(this);
		j.addActionListener(this);
		k.addActionListener(this);
		l.addActionListener(this);
		m.addActionListener(this);
		n.addActionListener(this);
		o.addActionListener(this);
		p.addActionListener(this);
		q.addActionListener(this);
		r.addActionListener(this);
		s.addActionListener(this);
		t.addActionListener(this);
		u.addActionListener(this);
		v.addActionListener(this);
		w.addActionListener(this);
		x.addActionListener(this);
		y.addActionListener(this);
		z.addActionListener(this);
		begin.addActionListener(this);
		easy.addActionListener(this);
		medium.addActionListener(this);
		hard.addActionListener(this);

		GridLayout aaa = new GridLayout(3, 0); // 전체 panel에 대한 layout 설정
		FlowLayout bbb = new FlowLayout(FlowLayout.CENTER, 10, 50); // displayTOP에 대한 layout // begin버튼
		FlowLayout ccc = new FlowLayout(FlowLayout.CENTER, 10, 70); // display2에 대한 layout
		GridLayout ddd = new GridLayout(3, 9, 10, 10); // display1에 대한 layout // 알파벳 (3줄 x 9칸)

		Container root = getContentPane(); // 컨테이너 타입의 객체 root
		root.setLayout(aaa); // grid
		root.setBackground(Color.white);

		displayTOP.add(begin);
		displayTOP.setLayout(bbb);
		displayTOP.setBackground(Color.white);

		root.add(displayTOP); // TOP을 컨테이너에 등록
		display1.setLayout(ddd);
		display1.setBackground(Color.white);

		a.setBackground(Color.orange);
		b.setBackground(Color.orange);
		c.setBackground(Color.orange);
		d.setBackground(Color.orange);
		e.setBackground(Color.orange);
		f.setBackground(Color.orange);
		g.setBackground(Color.orange);
		h.setBackground(Color.orange);
		i.setBackground(Color.orange);
		j.setBackground(Color.orange);
		k.setBackground(Color.orange);
		l.setBackground(Color.orange);
		m.setBackground(Color.orange);
		n.setBackground(Color.orange);
		o.setBackground(Color.orange);
		p.setBackground(Color.orange);
		q.setBackground(Color.orange);
		r.setBackground(Color.orange);
		s.setBackground(Color.orange);
		t.setBackground(Color.orange);
		u.setBackground(Color.orange);
		v.setBackground(Color.orange);
		w.setBackground(Color.orange);
		x.setBackground(Color.orange);
		y.setBackground(Color.orange);
		z.setBackground(Color.orange);
		display1.add(a);
		display1.add(b);
		display1.add(c);
		display1.add(d);
		display1.add(e);
		display1.add(f);
		display1.add(g);
		display1.add(h);
		display1.add(i);
		display1.add(j);
		display1.add(k);
		display1.add(l);
		display1.add(m);
		display1.add(n);
		display1.add(o);
		display1.add(p);
		display1.add(q);
		display1.add(r);
		display1.add(s);
		display1.add(t);
		display1.add(u);
		display1.add(v);
		display1.add(w);
		display1.add(x);
		display1.add(y);
		display1.add(z);

		root.add(display1);

		display2.setLayout(ccc);
		display2.setBackground(Color.white);
		display2.add(text);
		display2.add(easy);
		display2.add(medium);
		display2.add(hard);
		root.add(display2);
		setContentPane(root);

		a.setEnabled(false);
		b.setEnabled(false);
		c.setEnabled(false);
		d.setEnabled(false);
		e.setEnabled(false);
		f.setEnabled(false);
		g.setEnabled(false);
		h.setEnabled(false);
		i.setEnabled(false);
		j.setEnabled(false);
		k.setEnabled(false);
		l.setEnabled(false);
		m.setEnabled(false);
		n.setEnabled(false);
		o.setEnabled(false);
		p.setEnabled(false);
		q.setEnabled(false);
		r.setEnabled(false);
		s.setEnabled(false);
		t.setEnabled(false);
		u.setEnabled(false);
		v.setEnabled(false);
		w.setEnabled(false);
		x.setEnabled(false);
		y.setEnabled(false);
		z.setEnabled(false);

		// begin이 눌리면 그때부터 활성화 (true)
		easy.setEnabled(false);
		medium.setEnabled(true);
		hard.setEnabled(true);

		words[0] = "korea"; // 200개 이상의 단어 구성, 철자 4개 이상 12개 이하
		words[1] = "hansung";
		words[2] = "computer";
		words[3] = "engineering";
		words[4] = "science";
		words[5] = "university";
		words[6] = "college";
		words[7] = "eclipse";
		words[8] = "major";
		words[9] = "release";
		words[10] = "library";
		words[11] = "float";
		words[12] = "double";
		words[13] = "dictionary";
		words[14] = "poland";
		words[15] = "evolution";
		words[16] = "revolution";
		words[17] = "reject";
		words[18] = "subject";
		words[19] = "vector";
		words[20] = "applet";
		words[21] = "repository";
		words[22] = "remote";
		words[23] = "branch";
		words[24] = "environment";
		words[25] = "short";
		words[26] = "electronic";
		words[27] = "reference";
		words[28] = "agreement";
		words[29] = "fashion";
		words[30] = "configure";
		words[31] = "programming";
		words[32] = "request";
		words[33] = "database";
		words[34] = "jealous";
		words[35] = "amazon";
		words[36] = "password";
		words[37] = "compliment";
		words[38] = "complication";
		words[39] = "description";
		words[40] = "default";
		words[41] = "account";
		words[42] = "innovation";
		words[43] = "collaborate";
		words[44] = "germany";
		words[45] = "syndrome";
		words[46] = "report";
		words[47] = "gender";
		words[48] = "coffee";
		words[49] = "design";
		words[50] = "translate";
		words[51] = "analyze";
		words[52] = "image";
		words[53] = "segment";
		words[54] = "private";
		words[55] = "public";
		words[56] = "protect";
		words[57] = "editor";
		words[58] = "identify";
		words[59] = "statement";
		words[60] = "access";
		words[61] = "download";
		words[62] = "upload";
		words[63] = "address";
		words[64] = "relieve";
		words[65] = "satisfied";
		words[66] = "health";
		words[67] = "static";
		words[68] = "decrease";
		words[69] = "increase";
		words[70] = "practice";
		words[71] = "yield";
		words[72] = "success";
		words[73] = "failure";
		words[74] = "proof";
		words[75] = "evidence";
		words[76] = "innocence";
		words[77] = "virtual";
		words[78] = "urgent";
		words[79] = "desperate";
		words[80] = "indifferent";
		words[81] = "apologize";
		words[82] = "grateful";
		words[83] = "critical";
		words[84] = "struct";
		words[85] = "insistence";
		words[86] = "encourage";
		words[87] = "persuade";
		words[88] = "discourage";
		words[89] = "enable";
		words[90] = "disable";
		words[91] = "force";
		words[92] = "compel";
		words[93] = "inhabit";
		words[94] = "permit";
		words[95] = "admit";
		words[96] = "forbid";
		words[97] = "infinite";
		words[98] = "destination";
		words[99] = "board";
		words[100] = "destiny";
		words[101] = "community";
		words[102] = "support";
		words[103] = "tutor";
		words[104] = "spark";
		words[105] = "company";
		words[106] = "trend";
		words[107] = "apparel";
		words[108] = "modify";
		words[109] = "appropriate";
		words[110] = "indicate";
		words[111] = "ensure";
		words[112] = "proper";
		words[113] = "suitable";
		words[114] = "accept";
		words[115] = "verify";
		words[116] = "device";
		words[117] = "deviate";
		words[118] = "certain";
		words[119] = "interact";
		words[120] = "restrict";
		words[121] = "confident";
		words[122] = "optimistic";
		words[123] = "social";
		words[124] = "forget";
		words[125] = "network";
		words[126] = "string";
		words[127] = "stream";
		words[128] = "stock";
		words[129] = "select";
		words[130] = "selfish";
		words[131] = "forward";
		words[132] = "frequency";
		words[133] = "fiction";
		words[134] = "novel";
		words[135] = "egoism";
		words[136] = "ambiguous";
		words[137] = "abstract";
		words[138] = "vague";
		words[139] = "insight";
		words[140] = "deposit";
		words[141] = "switch";
		words[142] = "estimate";
		words[143] = "quote";
		words[144] = "confirm";
		words[145] = "instinctive";
		words[146] = "cinically";
		words[147] = "lobbyist";
		words[148] = "replay";
		words[149] = "executive";
		words[150] = "occasion";
		words[151] = "desire";
		words[152] = "explosive";
		words[153] = "trigger";
		words[154] = "induce";
		words[155] = "reduce";
		words[156] = "feast";
		words[157] = "reception";
		words[158] = "diplomacy";
		words[159] = "motivator";
		words[160] = "problem";
		words[161] = "christmas";
		words[162] = "banquet";
		words[163] = "occasion";
		words[164] = "national";
		words[165] = "domestic";
		words[166] = "represent";
		words[167] = "thunder";
		words[168] = "attention";
		words[169] = "memory";
		words[170] = "speech";
		words[171] = "season";
		words[172] = "grade";
		words[173] = "professor";
		words[174] = "lecture";
		words[175] = "laboratory";
		words[176] = "experiment";
		words[177] = "hypothesis";
		words[178] = "observation";
		words[179] = "require";
		words[180] = "distant";
		words[181] = "accurate";
		words[182] = "precise";
		words[183] = "notation";
		words[184] = "competent";
		words[185] = "dedicate";
		words[186] = "devote";
		words[187] = "debate";
		words[188] = "discuss";
		words[189] = "foreign";
		words[190] = "forever";
		words[191] = "justice";
		words[192] = "topic";
		words[193] = "shield";
		words[194] = "swear";
		words[195] = "accuse";
		words[196] = "ability";
		words[197] = "original";
		words[198] = "believe";
		words[199] = "trust";
		words[200] = "violence";

		for (int i = 0; i < checked.length; i++) {
			checked[i] = 0; // 아직 선택되지 않은 단어 (0)으로 초기화
		}

		for (int i = 0; i < 12; i++) {
			word1[i] = ' '; // character // 프로그램 안에서 맞는지 틀린지
			word2[i] = " "; // string // 화면에 내보낼 때
		}

		/* 필요한 변수들의 초기치 설정 */
		wins = 0;
		looses = 0;
		winningProsentige = 0.0;
	}

	public void paint(Graphics screen) {
		super.paint(screen);
		Graphics2D screen2D = (Graphics2D) screen;
		screen2D.setFont(warningFont);

		screen2D.drawLine(70, 60, 130, 60);
		screen2D.drawLine(70, 60, 70, 80);
		screen2D.drawLine(130, 60, 130, 170);
		screen2D.drawLine(60, 170, 160, 170);

		if (level == 0) { // Easy: 10번
			switch (guessNum) {
			case 1:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				break;

			case 2:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 110); // 몸통 1/3
				break;

			case 3:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 120); // 몸통 2/3
				break;

			case 4:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				break;

			case 5:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(70, 110, 90, 110); // 오른팔
				break;

			case 6:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				break;

			case 7:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				screen2D.drawLine(70, 130, 85, 140); // 오른 다리 절반
				break;

			case 8:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				screen2D.drawLine(70, 130, 85, 150); // 오른 다리
				break;

			case 9:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				screen2D.drawLine(70, 130, 55, 140); // 왼 다리 절반
				screen2D.drawLine(70, 130, 85, 150); // 오른 다리
				break;

			case 10:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				screen2D.drawLine(70, 130, 55, 150); // 왼 다리
				screen2D.drawLine(70, 130, 85, 150); // 오른 다리
				break;
			}
		}

		if (level == 1) { // Medium: 8번
			switch (guessNum) {
			case 1:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				break;

			case 2:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 110); // 몸통 1/3
				break;

			case 3:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 120); // 몸통 2/3
				break;

			case 4:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				break;

			case 5:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 70, 110); // 왼팔
				break;

			case 6:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				break;

			case 7:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				screen2D.drawLine(70, 130, 85, 150); // 오른 다리
				break;

			case 8:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				screen2D.drawLine(70, 130, 55, 150); // 왼 다리
				screen2D.drawLine(70, 130, 85, 150); // 오른 다리
				break;
			}
		}

		if (level == 2) { // Hard: 6번
			switch (guessNum) {
			case 1:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				break;

			case 2:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				break;

			case 3:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				break;

			case 4:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				break;

			case 5:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				screen2D.drawLine(70, 130, 85, 150); // 오른 다리
				break;

			case 6:
				screen2D.drawOval(60, 80, 20, 20); // 얼굴
				screen2D.drawLine(70, 100, 70, 130); // 몸통
				screen2D.drawLine(50, 110, 90, 110); // 팔
				screen2D.drawLine(70, 130, 55, 150); // 왼 다리
				screen2D.drawLine(70, 130, 85, 150); // 오른 다리
				break;
			}
		}

		screen2D.setColor(Color.RED);
		screen2D.drawString(Integer.toString(guessNum) + " guesses left", 340, 240);
		screen2D.setFont(normalFont);
		screen2D.setColor(Color.BLACK);
		screen2D.drawString("Current skill level: " + slevel[level], 300, 220);
		screen2D.drawString("Wins ", 220, 200);
		screen2D.drawString(Integer.toString((int) wins), 265, 200);
		screen2D.drawString("Looses", 300, 200);
		screen2D.drawString(Integer.toString((int) looses), 365, 200);
		screen2D.drawString("WinningProsentige", 400, 200);
		screen2D.drawString(Double.toString(winningProsentige) + "%", 555, 200);

		if (word_length == 4) { // 단어의 길이 4-12로 제한
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			// screen2D.drawImage(img, 100, 100, this);
			screen2D.drawString(word2[0], 300, 150);
			screen2D.drawString(word2[1], 320, 150);
			screen2D.drawString(word2[2], 340, 150);
			screen2D.drawString(word2[3], 360, 150);
		}

		if (word_length == 5) {
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			screen2D.drawString(word2[0], 300, 150);
			screen2D.drawString(word2[1], 320, 150);
			screen2D.drawString(word2[2], 340, 150);
			screen2D.drawString(word2[3], 360, 150);
			screen2D.drawString(word2[4], 380, 150);
		}

		if (word_length == 6) {
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			screen2D.drawString(word2[0], 300, 150);
			screen2D.drawString(word2[1], 320, 150);
			screen2D.drawString(word2[2], 340, 150);
			screen2D.drawString(word2[3], 360, 150);
			screen2D.drawString(word2[4], 380, 150);
			screen2D.drawString(word2[5], 400, 150);
		}

		if (word_length == 7) {
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			screen2D.drawString(word2[0], 300, 150);
			screen2D.drawString(word2[1], 320, 150);
			screen2D.drawString(word2[2], 340, 150);
			screen2D.drawString(word2[3], 360, 150);
			screen2D.drawString(word2[4], 380, 150);
			screen2D.drawString(word2[5], 400, 150);
			screen2D.drawString(word2[6], 420, 150);
		}

		if (word_length == 8) {
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			screen2D.drawString(word2[0], 300, 150);
			screen2D.drawString(word2[1], 320, 150);
			screen2D.drawString(word2[2], 340, 150);
			screen2D.drawString(word2[3], 360, 150);
			screen2D.drawString(word2[4], 380, 150);
			screen2D.drawString(word2[5], 400, 150);
			screen2D.drawString(word2[6], 420, 150);
			screen2D.drawString(word2[7], 440, 150);
		}

		if (word_length == 9) {
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			screen2D.drawString(word2[0], 300, 150);
			screen2D.drawString(word2[1], 320, 150);
			screen2D.drawString(word2[2], 340, 150);
			screen2D.drawString(word2[3], 360, 150);
			screen2D.drawString(word2[4], 380, 150);
			screen2D.drawString(word2[5], 400, 150);
			screen2D.drawString(word2[6], 420, 150);
			screen2D.drawString(word2[7], 440, 150);
			screen2D.drawString(word2[8], 460, 150);
		}

		if (word_length == 10) {
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			screen2D.drawString(word2[0], 300, 150);
			screen2D.drawString(word2[1], 320, 150);
			screen2D.drawString(word2[2], 340, 150);
			screen2D.drawString(word2[3], 360, 150);
			screen2D.drawString(word2[4], 380, 150);
			screen2D.drawString(word2[5], 400, 150);
			screen2D.drawString(word2[6], 420, 150);
			screen2D.drawString(word2[7], 440, 150);
			screen2D.drawString(word2[8], 460, 150);
			screen2D.drawString(word2[9], 480, 150);
		}

		if (word_length == 11) {
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			screen2D.drawString(word2[0], 300, 160);
			screen2D.drawString(word2[1], 320, 160);
			screen2D.drawString(word2[2], 340, 160);
			screen2D.drawString(word2[3], 360, 160);
			screen2D.drawString(word2[4], 380, 160);
			screen2D.drawString(word2[5], 400, 160);
			screen2D.drawString(word2[6], 420, 160);
			screen2D.drawString(word2[7], 440, 160);
			screen2D.drawString(word2[8], 460, 160);
			screen2D.drawString(word2[9], 480, 160);
			screen2D.drawString(word2[10], 500, 160);
		}

		if (word_length == 12) {
			screen2D.setFont(normalFont);
			screen2D.setColor(Color.BLACK);
			screen2D.drawString(word2[0], 300, 160);
			screen2D.drawString(word2[1], 320, 160);
			screen2D.drawString(word2[2], 340, 160);
			screen2D.drawString(word2[3], 360, 160);
			screen2D.drawString(word2[4], 380, 160);
			screen2D.drawString(word2[5], 400, 160);
			screen2D.drawString(word2[6], 420, 160);
			screen2D.drawString(word2[7], 440, 160);
			screen2D.drawString(word2[8], 460, 160);
			screen2D.drawString(word2[9], 480, 160);
			screen2D.drawString(word2[10], 500, 160);
			screen2D.drawString(word2[11], 520, 160);
		}
		// 답이 맞은 단어에 대한 화면 표시
		// 답이 틀린 단어에 대한 화면 표시
		// 시도한 횟수에 대하여 맞은 단어와 틀린 단어의 수 등을 표시
	}

	public void wordSelect() {
		double sel_num = Math.random() * 201;// 0~200.xx
		int selection = (int) Math.floor(sel_num); // 0~200
		while (true) { /* 이미 선택된 단어가 다시 선택되는 경우는 배제해야 함 */ // 나왔던 단어가 또 나오면 안됨
			if (checked[selection] == 0) { // 아직 뽑힌 단어가 아니라면 0
				checked[selection] = 1; // 뽑힌 단어로 표시
				break;
			} else {
				sel_num = Math.random() * 201; // 이미 나온 단어면 다시 뽑기
				selection = (int) Math.floor(sel_num);
			}
		}
		String sel_Word;
		if (words[selection] != null) { // 고른 단어가 null이 아닐때까지
			sel_Word = words[selection].toLowerCase();
			word_length = sel_Word.length();

			char[] temp = sel_Word.toCharArray(); // character 배열로 변환
			for (int index1 = 0; index1 < word_length; index1++) {
				word1[index1] = temp[index1];
			}
			for (int index2 = 0; index2 < word_length; index2++) {
				word2[index2] = "_"; // .또는 _로 유저에게 단어의 철자 수를 알려줌
			}
		}
	}

	public void word_reset() {
		for (int i = 0; i < 12; i++) {
			word2[i] = "_";
		}
		wordSelect();
	}

	public void spell_check(char spell) {
		int check_key = 0;
		for (int i = 0; i < 12; i++) { // 12는 좋은 표현이 아님
			if (word1[i] != ' ') {
				if (word1[i] == spell) {
					word2[i] = "" + spell;
					check_key = 1;
					repaint();
				}
			}
		}

		if (check_key == 0) { // 끝까지 다 찾았는데 check_key가 0이면 특정 알파(a)가 없음
			guessNum--;
			repaint();
		}
		Adjust_display();
		repaint();
	}

	public void Adjust_display() {
		if (word_length == 4) {
			if (word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_") {
				// 단어 추정 성공
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				e.setEnabled(false);
				f.setEnabled(false);
				g.setEnabled(false);
				h.setEnabled(false);
				i.setEnabled(false);
				j.setEnabled(false);
				k.setEnabled(false);
				l.setEnabled(false);
				m.setEnabled(false);
				n.setEnabled(false);
				o.setEnabled(false);
				p.setEnabled(false);
				q.setEnabled(false);
				r.setEnabled(false);
				s.setEnabled(false);
				t.setEnabled(false);
				u.setEnabled(false);
				v.setEnabled(false);
				w.setEnabled(false);
				x.setEnabled(false);
				y.setEnabled(false);
				z.setEnabled(false);
				begin.setEnabled(true);
				if (level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins / (wins + looses)) * 100.0;
				repaint();
			}
		}

		if (word_length == 5) {
			if (word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_" && word2[4] != "_") {
				// 단어 추정 성공
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				e.setEnabled(false);
				f.setEnabled(false);
				g.setEnabled(false);
				h.setEnabled(false);
				i.setEnabled(false);
				j.setEnabled(false);
				k.setEnabled(false);
				l.setEnabled(false);
				m.setEnabled(false);
				n.setEnabled(false);
				o.setEnabled(false);
				p.setEnabled(false);
				q.setEnabled(false);
				r.setEnabled(false);
				s.setEnabled(false);
				t.setEnabled(false);
				u.setEnabled(false);
				v.setEnabled(false);
				w.setEnabled(false);
				x.setEnabled(false);
				y.setEnabled(false);
				z.setEnabled(false);
				begin.setEnabled(true);
				if (level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins / (wins + looses)) * 100.0;
				repaint();
			}
		}

		if (word_length == 6) {
			if (word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_" && word2[4] != "_" && word2[5] != "_") {
				// 단어 추정 성공
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				e.setEnabled(false);
				f.setEnabled(false);
				g.setEnabled(false);
				h.setEnabled(false);
				i.setEnabled(false);
				j.setEnabled(false);
				k.setEnabled(false);
				l.setEnabled(false);
				m.setEnabled(false);
				n.setEnabled(false);
				o.setEnabled(false);
				p.setEnabled(false);
				q.setEnabled(false);
				r.setEnabled(false);
				s.setEnabled(false);
				t.setEnabled(false);
				u.setEnabled(false);
				v.setEnabled(false);
				w.setEnabled(false);
				x.setEnabled(false);
				y.setEnabled(false);
				z.setEnabled(false);
				begin.setEnabled(true);
				if (level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins / (wins + looses)) * 100.0;
				repaint();
			}
		}

		if (word_length == 7) {
			if (word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_" && word2[4] != "_" && word2[5] != "_" && word2[6] != "_") {
				// 단어 추정 성공
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				e.setEnabled(false);
				f.setEnabled(false);
				g.setEnabled(false);
				h.setEnabled(false);
				i.setEnabled(false);
				j.setEnabled(false);
				k.setEnabled(false);
				l.setEnabled(false);
				m.setEnabled(false);
				n.setEnabled(false);
				o.setEnabled(false);
				p.setEnabled(false);
				q.setEnabled(false);
				r.setEnabled(false);
				s.setEnabled(false);
				t.setEnabled(false);
				u.setEnabled(false);
				v.setEnabled(false);
				w.setEnabled(false);
				x.setEnabled(false);
				y.setEnabled(false);
				z.setEnabled(false);
				begin.setEnabled(true);
				if (level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins / (wins + looses)) * 100.0;
				repaint();
			}
		}

		if (word_length == 8) {
			if (word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_" && word2[4] != "_" && word2[5] != "_" && word2[6] != "_" && word2[7] != "_") {
				// 단어 추정 성공
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				e.setEnabled(false);
				f.setEnabled(false);
				g.setEnabled(false);
				h.setEnabled(false);
				i.setEnabled(false);
				j.setEnabled(false);
				k.setEnabled(false);
				l.setEnabled(false);
				m.setEnabled(false);
				n.setEnabled(false);
				o.setEnabled(false);
				p.setEnabled(false);
				q.setEnabled(false);
				r.setEnabled(false);
				s.setEnabled(false);
				t.setEnabled(false);
				u.setEnabled(false);
				v.setEnabled(false);
				w.setEnabled(false);
				x.setEnabled(false);
				y.setEnabled(false);
				z.setEnabled(false);
				begin.setEnabled(true);
				if (level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins / (wins + looses)) * 100.0;
				repaint();
			}
		}

		if (word_length == 9) {
			if (word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_" && word2[4] != "_" && word2[5] != "_" && word2[6] != "_" && word2[7] != "_" && word2[8] != "_") {
				// 단어 추정 성공
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				e.setEnabled(false);
				f.setEnabled(false);
				g.setEnabled(false);
				h.setEnabled(false);
				i.setEnabled(false);
				j.setEnabled(false);
				k.setEnabled(false);
				l.setEnabled(false);
				m.setEnabled(false);
				n.setEnabled(false);
				o.setEnabled(false);
				p.setEnabled(false);
				q.setEnabled(false);
				r.setEnabled(false);
				s.setEnabled(false);
				t.setEnabled(false);
				u.setEnabled(false);
				v.setEnabled(false);
				w.setEnabled(false);
				x.setEnabled(false);
				y.setEnabled(false);
				z.setEnabled(false);
				begin.setEnabled(true);
				if (level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins / (wins + looses)) * 100.0;
				repaint();
			}
		}

		if (word_length == 10) {
			if (word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_" && word2[4] != "_" && word2[5] != "_" && word2[6] != "_" && word2[7] != "_" && word2[8] != "_" && word2[9] != "_") {
				// 단어 추정 성공
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				e.setEnabled(false);
				f.setEnabled(false);
				g.setEnabled(false);
				h.setEnabled(false);
				i.setEnabled(false);
				j.setEnabled(false);
				k.setEnabled(false);
				l.setEnabled(false);
				m.setEnabled(false);
				n.setEnabled(false);
				o.setEnabled(false);
				p.setEnabled(false);
				q.setEnabled(false);
				r.setEnabled(false);
				s.setEnabled(false);
				t.setEnabled(false);
				u.setEnabled(false);
				v.setEnabled(false);
				w.setEnabled(false);
				x.setEnabled(false);
				y.setEnabled(false);
				z.setEnabled(false);
				begin.setEnabled(true);
				if (level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins / (wins + looses)) * 100.0;
				repaint();
			}
		}

		if (word_length == 11) {
			if (word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_" && word2[4] != "_" && word2[5] != "_" && word2[6] != "_" && word2[7] != "_" && word2[8] != "_" && word2[9] != "_" && word2[10] != "_") {
				// 단어 추정 성공
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				e.setEnabled(false);
				f.setEnabled(false);
				g.setEnabled(false);
				h.setEnabled(false);
				i.setEnabled(false);
				j.setEnabled(false);
				k.setEnabled(false);
				l.setEnabled(false);
				m.setEnabled(false);
				n.setEnabled(false);
				o.setEnabled(false);
				p.setEnabled(false);
				q.setEnabled(false);
				r.setEnabled(false);
				s.setEnabled(false);
				t.setEnabled(false);
				u.setEnabled(false);
				v.setEnabled(false);
				w.setEnabled(false);
				x.setEnabled(false);
				y.setEnabled(false);
				z.setEnabled(false);
				begin.setEnabled(true);
				if (level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins / (wins + looses)) * 100.0;
				repaint();
			}
		}

		if (word_length == 12) {
			if (word2[0] != "_" && word2[1] != "_" && word2[2] != "_" && word2[3] != "_" && word2[4] != "_" && word2[5] != "_" && word2[6] != "_" && word2[7] != "_" && word2[8] != "_" && word2[9] != "_" && word2[10] != "_" && word2[11] != "_") {
				// 단어 추정 성공
				a.setEnabled(false);
				b.setEnabled(false);
				c.setEnabled(false);
				d.setEnabled(false);
				e.setEnabled(false);
				f.setEnabled(false);
				g.setEnabled(false);
				h.setEnabled(false);
				i.setEnabled(false);
				j.setEnabled(false);
				k.setEnabled(false);
				l.setEnabled(false);
				m.setEnabled(false);
				n.setEnabled(false);
				o.setEnabled(false);
				p.setEnabled(false);
				q.setEnabled(false);
				r.setEnabled(false);
				s.setEnabled(false);
				t.setEnabled(false);
				u.setEnabled(false);
				v.setEnabled(false);
				w.setEnabled(false);
				x.setEnabled(false);
				y.setEnabled(false);
				z.setEnabled(false);
				begin.setEnabled(true);
				if (level == 0) {
					medium.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 1) {
					easy.setEnabled(true);
					hard.setEnabled(true);
				} else if (level == 2) {
					easy.setEnabled(true);
					medium.setEnabled(true);
				}
				wins++;
				winningProsentige = (wins / (wins + looses)) * 100.0;
				repaint();
			}
		}

		if (guessNum <= 0) { // 단어 추정 실패

			// 버튼 눌릴 수 없게 만듬
			a.setEnabled(false);
			b.setEnabled(false);
			c.setEnabled(false);
			d.setEnabled(false);
			e.setEnabled(false);
			f.setEnabled(false);
			g.setEnabled(false);
			h.setEnabled(false);
			i.setEnabled(false);
			j.setEnabled(false);
			k.setEnabled(false);
			l.setEnabled(false);
			m.setEnabled(false);
			n.setEnabled(false);
			o.setEnabled(false);
			p.setEnabled(false);
			q.setEnabled(false);
			r.setEnabled(false);
			s.setEnabled(false);
			t.setEnabled(false);
			u.setEnabled(false);
			v.setEnabled(false);
			w.setEnabled(false);
			x.setEnabled(false);
			y.setEnabled(false);
			z.setEnabled(false);

			// 정답을 화면에 표시
			for (int i = 0; i < 12; i++) {
				word2[i] = "" + word1[i];
			}

			begin.setEnabled(true);
			// level에 따른 버튼 활성화 작업
			if (level == 0) {
				medium.setEnabled(true);
				hard.setEnabled(true);
			} else if (level == 1) {
				easy.setEnabled(true);
				hard.setEnabled(true);
			} else if (level == 2) {
				easy.setEnabled(true);
				medium.setEnabled(true);
			}
			looses++;
			winningProsentige = (wins / (wins + looses)) * 100.0;
			repaint();
		}
	}

	public void actionPerformed(ActionEvent event) {
		String typed = event.getActionCommand(); // 어떤 버튼을 눌렀는지 알려줌
		if (typed.equals("BEGIN")) {
			for (int i = 0; i < 12; i++) {
				word1[i] = ' ';
				word2[i] = "_";
			}

			easy.setEnabled(false);
			medium.setEnabled(false);
			hard.setEnabled(false);

			if (level == 0) {
				guessNum = 10;
			} else if (level == 1) {
				guessNum = 8;
			} else if (level == 2) {
				guessNum = 6;
			}

			repaint();
			a.setEnabled(true);
			b.setEnabled(true);
			c.setEnabled(true);
			d.setEnabled(true);
			e.setEnabled(true);
			f.setEnabled(true);
			g.setEnabled(true);
			h.setEnabled(true);
			i.setEnabled(true);
			j.setEnabled(true);
			k.setEnabled(true);
			l.setEnabled(true);
			m.setEnabled(true);
			n.setEnabled(true);
			o.setEnabled(true);
			p.setEnabled(true);
			q.setEnabled(true);
			r.setEnabled(true);
			s.setEnabled(true);
			t.setEnabled(true);
			u.setEnabled(true);
			v.setEnabled(true);
			w.setEnabled(true);
			x.setEnabled(true);
			y.setEnabled(true);
			z.setEnabled(true);

			begin.setEnabled(false);
			word_reset();
		}
		if (typed.equals("A")) {
			a.setEnabled(false);
			spell_check('a');
		}
		if (typed.equals("B")) {
			b.setEnabled(false);
			spell_check('b');
		}
		if (typed.equals("C")) {
			c.setEnabled(false);
			spell_check('c');
		}
		if (typed.equals("D")) {
			d.setEnabled(false);
			spell_check('d');
		}
		if (typed.equals("E")) {
			e.setEnabled(false);
			spell_check('e');
		}
		if (typed.equals("F")) {
			f.setEnabled(false);
			spell_check('f');
		}
		if (typed.equals("G")) {
			g.setEnabled(false);
			spell_check('g');
		}
		if (typed.equals("H")) {
			h.setEnabled(false);
			spell_check('h');
		}
		if (typed.equals("I")) {
			i.setEnabled(false);
			spell_check('i');
		}
		if (typed.equals("J")) {
			j.setEnabled(false);
			spell_check('j');
		}
		if (typed.equals("K")) {
			k.setEnabled(false);
			spell_check('k');
		}
		if (typed.equals("L")) {
			l.setEnabled(false);
			spell_check('l');
		}
		if (typed.equals("M")) {
			m.setEnabled(false);
			spell_check('m');
		}
		if (typed.equals("N")) {
			n.setEnabled(false);
			spell_check('n');
		}
		if (typed.equals("O")) {
			o.setEnabled(false);
			spell_check('o');
		}
		if (typed.equals("P")) {
			p.setEnabled(false);
			spell_check('p');
		}
		if (typed.equals("Q")) {
			q.setEnabled(false);
			spell_check('q');
		}
		if (typed.equals("R")) {
			r.setEnabled(false);
			spell_check('r');
		}
		if (typed.equals("S")) {
			s.setEnabled(false);
			spell_check('s');
		}
		if (typed.equals("T")) {
			t.setEnabled(false);
			spell_check('t');
		}
		if (typed.equals("U")) {
			u.setEnabled(false);
			spell_check('u');
		}
		if (typed.equals("V")) {
			v.setEnabled(false);
			spell_check('v');
		}
		if (typed.equals("W")) {
			w.setEnabled(false);
			spell_check('w');
		}
		if (typed.equals("X")) {
			x.setEnabled(false);
			spell_check('x');
		}
		if (typed.equals("Y")) {
			y.setEnabled(false);
			spell_check('y');
		}
		if (typed.equals("Z")) {
			z.setEnabled(false);
			spell_check('z');
		}
		if (typed.equals("EASY")) {
			easy.setEnabled(false);
			medium.setEnabled(true);
			hard.setEnabled(true);
			level = 0;
			repaint();
		}
		if (typed.equals("MEDIUM")) {
			medium.setEnabled(false);
			hard.setEnabled(true);
			easy.setEnabled(true);
			level = 1;
			repaint();
		}
		if (typed.equals("HARD")) {
			hard.setEnabled(false);
			medium.setEnabled(true);
			easy.setEnabled(true);
			level = 2;
			repaint();
		}
	}

	public static void main(String[] args) {
		HangmanEx h = new HangmanEx();

		h.init();
	}
}
