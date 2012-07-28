package core;

import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			IO file = new IO("C:/00001.vcf");
			String[] text = file.read();
			for (int i = 0; i < text.length; i++) {
				String[] hilfsvariable;
				if (text[i].startsWith("N:")) {
					hilfsvariable = text[i].split(";");
					if (hilfsvariable.length > 1) {
						hilfsvariable[0]=hilfsvariable[0].replace("N:", "");

						text[i] = "N:" + hilfsvariable[1] + ";"
								+ hilfsvariable[0] + ";;;";
						System.out.println("Name von "+hilfsvariable[0] + ", "
								+ hilfsvariable[1] + " wurde getauscht");
					}
				} else if (text[i].startsWith("FN:")) {
					hilfsvariable = text[i].split(",");
					
					if (hilfsvariable != null) {
						hilfsvariable[0]=hilfsvariable[0].replace("FN:", "");
						if (hilfsvariable.length > 1) {
							hilfsvariable[1] = hilfsvariable[1].substring(1);
							text[i] = "FN:" + hilfsvariable[1] + ", "
									+ hilfsvariable[0];
							System.out.println("Fullname von " + hilfsvariable[0]
									+ ", " + hilfsvariable[1]
									+ " wurde getauscht");
						}
					}else{
						System.out.println("nichts zu tauschen?");
					}

				}

			}
			file.write(text);
			System.out.println("Datei geschrieben");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
