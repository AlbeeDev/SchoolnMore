package calcolatrice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MioAscoltatore implements ActionListener{
	private JLabel l;
	private JButton[] bvec;
	private String op;
	private int i1,i2,opidx;
	private float f1,f2;
	private boolean fl1=false,fl2=false,neg1=false,neg2=false;
	public MioAscoltatore(JLabel l,JButton[] bvec) {
		this.l=l;
		this.bvec=bvec;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		l.setText(setText(b.getText(),l,bvec));
	}
	
	public String setText(String text, JLabel l,JButton[] bvec) {
		StringBuilder sb = new StringBuilder();
		try {
			Integer.parseInt(text);
			if(l.getText()=="") {
				enableAll(bvec, true);
			}
			return l.getText()+text;
		} catch (NumberFormatException e) {
			if(text=="=") {
				if(isOp(sb)) return"";
				try {
					String[] strf;
					if(op=="-") {
						strf=l.getText().split(op);
					}
					else {
						strf=l.getText().split("[+ x ÷ % ^]");
					}
					if(!fl1 && !fl2) {
						i1=Integer.parseInt(strf[0]);
						i2=Integer.parseInt(strf[1]);
					}
					if(fl1) {
						f1=Float.parseFloat(strf[0]);
					}
					else {
						fl1=true;
						f1=Integer.parseInt(strf[0]);
					}
					if(fl2) {
						f2=Float.parseFloat(strf[1]);
					}
					else {
						fl2=true;
						f2=Integer.parseInt(strf[1]);
					}
				} catch (Exception e2) {
					opidx=0;
					sb.delete(0, sb.length());
					if(!fl1 && !fl2) {
						int i=Integer.parseInt(l.getText());
						int result=0;
						if(op=="+") {
							result=i+i2;
						}
						if(op=="-") {
							result=i-i2;
						}
						if(op=="x") {
							result=i*i2;
						}
						if(op=="÷") {
							float f=i;
							f2=i2;
							float fr=f/f2;
							return sb.append(Float.toString(fr)).toString();
						}
						if(op=="%") {
							float f=i;
							f2=i2;
							float fr=(f*f2)/100f;
							return sb.append(Float.toString(fr)).toString();
						}
						if(op=="^") {
							float f=i;
							f2=i2;
							float fr=(float) Math.pow(f, f2);
							return sb.append(Float.toString(fr)).toString();
						}
						return sb.append(Integer.toString(result)).toString();
					}
					else {
						float f= Float.parseFloat(l.getText());
						float result=0;
						if(op=="+") {
							result=f+f2;
						}
						if(op=="-") {
							result=f-f2;
						}
						if(op=="x") {
							result=f*f2;
						}
						if(op=="÷") {
							result=f/f2;
						}
						if(op=="%") {
							result=(f*f2)/100f;
						}
						if(op=="^") {
							result=(float) Math.pow(f, f2);
						}
						return sb.append(Float.toString(result)).toString();
					}
				}
				enableOp(bvec,true);
				opidx=0;
				sb.delete(0, sb.length());
				if(!fl1 && !fl2) {
					int i=0;
					if(op=="+") {
						i=i1+i2;
					}
					if(op=="-") {
						i=i1-i2;
					}
					if(op=="x") {
						i=i1*i2;
					}
					if(op=="÷") {
						f1=i1;
						f2=i2;
						float fr=f1/f2;
						return sb.append(Float.toString(fr)).toString();
					}
					if(op=="%") {
						f1=i1;
						f2=i2;
						float fr=(f1*f2)/100f;
						return sb.append(Float.toString(fr)).toString();
					}
					if(op=="^") {
						f1=i1;
						f2=i2;
						float fr=(float) Math.pow(f1, f2);
						return sb.append(Float.toString(fr)).toString();
					}
					return sb.append(Integer.toString(i)).toString();
				}
				else {
					float f=0;
					if(op=="+") {
						f=f1+f2;
					}
					if(op=="-") {
						f=f1-f2;
					}
					if(op=="x") {
						f=f1*f2;
					}
					if(op=="÷") {
						f=f1/f2;
					}
					if(op=="%") {
						f=(f1*f2)/100;
					}
					if(op=="^") {
						f=(float) Math.pow(f1, f2);
					}
					return sb.append(Float.toString(f)).toString();
				}
			}
			if(text=="C") {
				enableAll(bvec,false);
				neg1=false;
				neg2=false;
				bvec[1].setEnabled(true);
				opidx=0;
				return "";
			}
			if(text=="⌫") {
				if(l.getText().length()==0) return l.getText();
				if(l.getText().length()-1==0) {
					enableAll(bvec, false);
				}
				sb.append(l.getText());
				Character ch=sb.charAt(sb.length()-1);
				if(ch=='.') {
					bvec[1].setEnabled(true);
				}
				if(ch=='+' || ch=='-' || ch=='x' || ch=='÷' || ch=='%' || ch=='^') {
					if(ch=='-' && opidx!=0) {
						sb.deleteCharAt(sb.length()-1);
						return sb.toString();
					}
					enableOp(bvec,true);
					opidx=0;
					neg2=false;
				}
				sb.deleteCharAt(sb.length()-1);
				return sb.toString();
			}
			if(text=="+" || text=="-" || text=="x" || text=="÷" || text=="%" || text=="x^y") {
				enableOp(bvec,false);
				bvec[1].setEnabled(true);
				if(text=="x^y") text="^";
				op=text;
				opidx=l.getText().length()+1;
				sb.append(text);
			}
			if(text=="+/-") {
				sb.append(l.getText());
				if(opidx==0) {
					if(neg1==true) {
						sb.deleteCharAt(0);
						neg1=true;
					}
					else {
						neg1=true;
						sb.insert(opidx, '-');
					}
				}
				else {
					if(neg2==true) {
						sb.deleteCharAt(opidx);
						neg2=false;
					}
					else {
						if(op=="-") {
							op="+";
							sb.replace(opidx-1, opidx, op);
						}
						else {
							neg2=true;
							sb.insert(opidx, '-');
						}
					}
				}
				return sb.toString();
			}
			if(text==".") {
				bvec[1].setEnabled(false);
				if(opidx==0) {
					fl1=true;
				}
				else {
					fl2=true;
				}
				if(l.getText()=="") {
					sb.append("0"+text);
					enableAll(bvec, true);
					return l.getText()+sb.toString();
				}
				sb.append(l.getText().charAt(l.getText().length()-1));
				try {
					Integer.parseInt(sb.toString());
				}catch(Exception e2) {
					sb.delete(0, sb.length());
					sb.append("0"+text);
					return l.getText()+sb.toString();
				}
				sb.delete(0, sb.length());
				sb.append(text);
			}
			if(text=="Log" || text=="Ln") {
				if(isOp(sb)) return "";
				float f;
				if(fl1) {
					f=Float.parseFloat(l.getText());
				}
				else {
					int i=Integer.parseInt(l.getText());
					f=i;
				}
				if(f>0) {
					float fr=0;
					if(text=="Log") fr=(float) Math.log10(f);
					if(text=="Ln") fr=(float) Math.log10(f);
					fl1=true;
					return sb.append(Float.toString(fr)).toString();
				}
			}
			if(text=="2√x") {
				if(isOp(sb)) return "";
				float f;
				if(fl1) {
					f=Float.parseFloat(l.getText());
				}
				else {
					int i=Integer.parseInt(l.getText());
					f=i;
				}
				if(f>=0) {
					float fr= (float) Math.sqrt(f);
					fl1=true;
					return sb.append(Float.toString(fr)).toString();
				}
			}
		}
		return l.getText()+sb.toString();
	}
	public boolean isOp(StringBuilder sb) {
		sb.append(l.getText());
		if(sb.charAt(sb.length()-1)=='+' || sb.charAt(sb.length()-1)=='-' || sb.charAt(sb.length()-1)=='x' || sb.charAt(sb.length()-1)=='÷' || sb.charAt(sb.length()-1)=='%') {
			enableOp(bvec,true);
			return true;
		}
		sb.delete(0, sb.length());
		return false;
	}
	public void enableOp(JButton[] bvec,boolean b) {
		bvec[4].setEnabled(b);
		bvec[8].setEnabled(b);
		bvec[12].setEnabled(b);
		bvec[16].setEnabled(b);
		bvec[17].setEnabled(b);
		bvec[18].setEnabled(b);
		bvec[19].setEnabled(b);
		bvec[22].setEnabled(b);
		bvec[23].setEnabled(b);
	}
	public void enableAll(JButton[] bvec,boolean b) {
		bvec[0].setEnabled(b);
		bvec[3].setEnabled(b);
		enableOp(bvec,b);
	}
}