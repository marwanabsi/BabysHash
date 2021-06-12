import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class Drive extends Application {
	public File BabyFile;
	public Hash hashTabel = new Hash(2);

	public static void main(String[] args) {
//		System.out.println("Hayyyy "); 
//		Hash u1 = new Hash(10);
//		Heap h1 = new Heap(10);
//		
//		Babys b1 = new Babys("ali", "m");
//		Babys b2 = new Babys("oui", "m");
//		Babys b3 = new Babys("ali", "m");
//		
//		frecuans f1 = new frecuans(2007, 100);
//		frecuans f2 = new frecuans(2008, 200);
//		frecuans f3 = new frecuans(2009, 300);
//		h1.insert(f1);
//		h1.insert(f2);
//		h1.insert(f3);
//		
//		
//		u1.insert(b1, h1);
//		u1.insert(b2, h1);
//		u1.insert(b3, h1);
//		
//		u1.printHashTable();
//		h1.sort();
//		h1.printSort();
		Application.launch(args);
	}

	public void start(Stage wind) throws Exception {
		BorderPane bp0 = new BorderPane();
		bp0.setPadding(new Insets(30));
		bp0.setId("pane1");
		Scene scene0 = new Scene(bp0, 400, 600);
		scene0.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());

		BorderPane bp1 = new BorderPane();
		bp1.setId("pane2");
		Scene scene1 = new Scene(bp1, 400, 600);
		scene1.getStylesheets().addAll(this.getClass().getResource("Style.css").toExternalForm());

		BorderPane bp2 = new BorderPane();
		bp2.setId("pane2");
		Scene scene2 = new Scene(bp2, 800, 500);
		BorderPane bp3 = new BorderPane();
		Scene scene3 = new Scene(bp3, 800, 500);
		BorderPane bp4 = new BorderPane();
		Scene scene4 = new Scene(bp4, 800, 500);
		BorderPane bp5 = new BorderPane();
		Scene scene5 = new Scene(bp5, 800, 500);
		BorderPane bp6 = new BorderPane();
		Scene scene6 = new Scene(bp6, 800, 500);
		BorderPane bp7 = new BorderPane();
		Scene scene7 = new Scene(bp7, 800, 500);
		BorderPane bp8 = new BorderPane();
		Scene scene8 = new Scene(bp8, 800, 500);

		// File Chooser
		FileChooser fileChooser;
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text File ", "*txt"),
				new ExtensionFilter("Exil Fil e ", "*.csv"));

		// Label TopLabel1 = new Label("Please choose a process");
//		TopLabel1.setFont(new Font(22));
//		bp1.setTop(TopLabel1);
//		BorderPane.setAlignment(TopLabel1, Pos.CENTER);

		// Button
		Button menub = new Button("Back");
		Button Show = new Button("Babys Data");
		Button browse = new Button("Please choose a Baby Record File");
		Button newName = new Button("Add new Name record");
		Button deleteName = new Button("Delete a name record");
		Button newFrec = new Button("Add a new year/freq");
		Button updateFrec = new Button("Update year/freq");
		Button SearchBaby = new Button("Search for a Name");
		Button maxFrequency = new Button("Name with max frequency");
		Button dataTabele = new Button("Babys Data");
		Button exit = new Button("Exit");

		// First Secne
		VBox fs = new VBox();
		fs.setSpacing(15);

		fs.getChildren().addAll(browse);
		fs.setAlignment(Pos.CENTER);
		bp0.setBottom(fs);

		// Menu
		VBox ss = new VBox();
		ss.setSpacing(15);
		ss.getChildren().addAll(Show,newName, deleteName, newFrec, updateFrec, SearchBaby, maxFrequency, exit);
		ss.setAlignment(Pos.CENTER);
		bp1.setCenter(ss);

		// Search for a Name Window
		Button search = new Button("Search");
		search.setFont(new Font(15));
		GridPane gp2 = new GridPane();
		Label resultForSearch = new Label();
		resultForSearch.setFont(new Font(13));
		gp2.setVgap(15);
		gp2.setHgap(5);
		gp2.add(new Label("Baby Name "), 0, 0); // label
		gp2.add(new Label("Baby Gender "), 0, 1);
		TextField bName = new TextField();
		gp2.add(bName, 1, 0);
		gp2.add(search, 1, 2);
		ComboBox<String> gender = new ComboBox<String>();
		gender.getItems().addAll("M", "F");
		gp2.add(gender, 1, 1);
		gp2.add(resultForSearch, 0, 3);
		gender.getSelectionModel().select(1);
		bp2.setCenter(gp2);
		gp2.setAlignment(Pos.CENTER);

		// Add new Name

		Button addNew = new Button("Add");
		addNew.setFont(new Font(15));
		GridPane gp3 = new GridPane();
		Label resultForAdd = new Label();
		resultForAdd.setFont(new Font(13));
		gp3.setVgap(15);
		gp3.setHgap(5);
		gp3.add(new Label("Baby Name "), 0, 0); // label
		gp3.add(new Label("Baby Gender "), 0, 1);
		gp3.add(new Label("Baby Year "), 0, 2); // label
		gp3.add(new Label("Baby Frequansy "), 0, 3);

		TextField bNameNew = new TextField();
		TextField bYearNew = new TextField();
		TextField bFrecNew = new TextField();

		gp3.add(bNameNew, 1, 0);
		gp3.add(bYearNew, 1, 2);
		gp3.add(bFrecNew, 1, 3);

		gp3.add(addNew, 1, 5);
		ComboBox<String> genderNew = new ComboBox<String>();
		genderNew.getItems().addAll("M", "F");
		gp3.add(genderNew, 1, 1);
		gp3.add(resultForAdd, 0, 5);
		genderNew.getSelectionModel().select(1);
		bp3.setCenter(gp3);
		gp3.setAlignment(Pos.CENTER);

		// Delete Node
		Button delete = new Button("Delete");
		delete.setFont(new Font(15));
		GridPane gp4 = new GridPane();
		Label resultForDelete = new Label();
		resultForDelete.setFont(new Font(13));
		gp4.setVgap(15);
		gp4.setHgap(5);
		gp4.add(new Label("Baby Name "), 0, 0); // label
		gp4.add(new Label("Baby Gender "), 0, 1);
		TextField bNameDelete = new TextField();
		gp4.add(bNameDelete, 1, 0);
		gp4.add(delete, 1, 2);
		ComboBox<String> genderDelete = new ComboBox<String>();
		genderDelete.getItems().addAll("M", "F");
		gp4.add(genderDelete, 1, 1);
		gp4.add(resultForDelete, 0, 3);
		genderDelete.getSelectionModel().select(1);
		bp4.setCenter(gp4);
		gp4.setAlignment(Pos.CENTER);

		// Add New Frecuans
		Button addNewFre = new Button("Add");
		addNewFre.setFont(new Font(15));
		GridPane gp5 = new GridPane();
		Label resultForAddFre = new Label();
		resultForAddFre.setFont(new Font(13));
		gp5.setVgap(15);
		gp5.setHgap(5);
		gp5.add(new Label("Baby Name "), 0, 0); // label
		gp5.add(new Label("Baby Gender "), 0, 1);
		gp5.add(new Label("Baby Year "), 0, 2); // label
		gp5.add(new Label("Baby Frequansy "), 0, 3);

		ComboBox<String> bNameNewFre = new ComboBox<String>();
		// bNameNewFre.getItems().add("");
		// TextField bNameNewFre = new TextField();

		TextField bYearNewFre = new TextField();
		TextField bFrecNewFre = new TextField();

		gp5.add(bNameNewFre, 1, 0);
		gp5.add(bYearNewFre, 1, 2);
		gp5.add(bFrecNewFre, 1, 3);

		gp5.add(addNewFre, 1, 5);
		ComboBox<String> genderNewFre = new ComboBox<String>();
		genderNewFre.getItems().addAll("M", "F");
		gp5.add(genderNewFre, 1, 1);
		gp5.add(resultForAddFre, 0, 5);
		genderNewFre.getSelectionModel().select(1);
		bp5.setCenter(gp5);
		gp5.setAlignment(Pos.CENTER);

		//Update Frecuance
		Button updateFre = new Button("Show / Update");
		updateFre.setFont(new Font(15));
		GridPane gp6 = new GridPane();
		Label resultForUpdate = new Label();
		resultForUpdate.setFont(new Font(13));
		gp6.setVgap(15);
		gp6.setHgap(5);
		gp6.add(new Label("Baby Name "), 0, 0); // label
		gp6.add(new Label("Baby Gender "), 0, 1);
		gp6.add(new Label("Convert from Year "), 0, 2); // label
		gp6.add(new Label("Convert from Frequansy "), 0, 3);
		gp6.add(new Label("To"), 2, 2); // label
		gp6.add(new Label("To"), 2, 3);

		ComboBox<String> bNameUpdateFre = new ComboBox<String>();

		TextField bYearUpdateFreOld = new TextField();
		TextField bFrecUpdateFreOld = new TextField();
		TextField bYearUpdateFreNew = new TextField();
		TextField bFrecUpdateFreNew = new TextField();

		gp6.add(bNameUpdateFre, 1, 0);
		gp6.add(bYearUpdateFreOld, 1, 2);
		gp6.add(bFrecUpdateFreOld, 1, 3);
		gp6.add(bYearUpdateFreNew, 3, 2);
		gp6.add(bFrecUpdateFreNew, 3, 3);

		gp6.add(updateFre, 1, 5);
		ComboBox<String> genderUpdateFre = new ComboBox<String>();
		genderUpdateFre.getItems().addAll("M", "F");
		gp6.add(genderUpdateFre, 1, 1);
		gp6.add(resultForUpdate, 5, 6);
		genderUpdateFre.getSelectionModel().select(1);
		bp6.setCenter(gp6);
		gp6.setAlignment(Pos.CENTER);

		// Max Frecuance
		Button maxFre = new Button("Name With Max Frecuance");
		Label resultForMax = new Label();
		maxFre.setFont(new Font(15));
		GridPane gp7 = new GridPane();
		gp7.add(maxFre, 1, 1);
		gp7.add(resultForMax, 2, 2);
		bp7.setCenter(gp7);
		gp7.setAlignment(Pos.CENTER);
//		
	TextArea textArea = new TextArea();
//		
		bp8.setCenter(textArea);
		// Button Action
		
		
		//Back Button
		menub.setOnAction(e -> {
			wind.setScene(scene1);
		});
		
		// Browes Action
		browse.setOnAction(e -> {
			List<File> babyFileList = fileChooser.showOpenMultipleDialog(wind);
			if (babyFileList != null) {
				int heabSize = babyFileList.size();
				babyFileList.stream().forEach(selectedFile -> {
					String S = selectedFile.getName();
					String numberOnly = S.replaceAll("[^0-9]", "");

					if (selectedFile.exists()) {

						Scanner in;
						try {
							in = new Scanner(selectedFile);
							String[] t;
							while (in.hasNext()) {
								t = in.nextLine().trim().split(",");
								if (t.length == 3) {

									Babys newBaby = new Babys(t[0].trim(), t[1].trim());
									frecuans newfrecuans = new frecuans(Integer.parseInt(numberOnly.trim()),
											Integer.parseInt(t[2].trim()));

									Heap frecHeap = new Heap(heabSize);
									frecHeap.insert(newfrecuans);
									hashTabel.insert(newBaby, frecHeap);
									
								}
							}
						} catch (FileNotFoundException e1) {
							System.out.println(e1);
						}
						wind.setScene(scene1);
					} else
						wind.setScene(scene0);

				});
				
				hashTabel.printHashTable();

			}
			System.out.println(hashTabel.getTableSize());
			// BabyFile = fileChooser.showOpenDialog(wind);

		});

		// Search Action
		SearchBaby.setOnAction(e -> {
			bp2.setBottom(menub);
			wind.setScene(scene2);
		});

		search.setOnAction(e -> {
			Babys sBaby = new Babys(bName.getText(), gender.getSelectionModel().getSelectedItem());
			HashNode d = hashTabel.findNode(sBaby) ;
			if(d!=null)
			resultForSearch.setText(d.toString());
			else
				resultForSearch.setText("Sorre We can't Find The Baby");

		});

		// Add new name Action
		newName.setOnAction(e -> {
			bp3.setBottom(menub);
			wind.setScene(scene3);
		});

		addNew.setOnAction(e -> {
			Babys sBabyN = new Babys(bNameNew.getText(), genderNew.getSelectionModel().getSelectedItem());

			if (!(hashTabel.find(sBabyN).equalsIgnoreCase("null"))) {
				resultForAdd.setText("This child exists. If you want to Edit him/her, please go to the Edit section");
			} else {
				Babys newBabyAdd = new Babys(bNameNew.getText().trim(),
						genderNew.getSelectionModel().getSelectedItem().trim());

				frecuans newfrecuansAdd = new frecuans(Integer.parseInt(bYearNew.getText().trim()),
						Integer.parseInt(bFrecNew.getText().trim()));

				Heap frecHeap = new Heap(1);
				frecHeap.insert(newfrecuansAdd);
				hashTabel.insert(newBabyAdd, frecHeap);

				resultForAdd.setText("We Add The baby");
				hashTabel.printHashTable();
			}
		});

		// Delete Name Action
		deleteName.setOnAction(e -> {
			bp4.setBottom(menub);
			wind.setScene(scene4);
		});

		delete.setOnAction(e -> {
			Babys newBabyDelete = new Babys(bNameDelete.getText().trim(),
					genderDelete.getSelectionModel().getSelectedItem().trim());
			if (!(hashTabel.find(newBabyDelete).equalsIgnoreCase("null"))) {
				hashTabel.remove(newBabyDelete);
				resultForDelete.setText("Delete Done for" + newBabyDelete.getName());
				hashTabel.printHashTable();
			} else {
				resultForDelete.setText("Sorry we can't Find the Baby");
			}

		});

		// New Year / Frecuance Action
		newFrec.setOnAction(e -> {
			for (int i = 0; i < hashTabel.getTableSize(); i++) {
				HashNode x[] = hashTabel.getTable();
				if (x[i] != null) {
					bNameNewFre.getItems().add(x[i].getData().getName());
				}
			}
			bp5.setBottom(menub);
			wind.setScene(scene5);
		});

		addNewFre.setOnAction(e -> {
			Babys newBabyFre = new Babys(bNameNewFre.getSelectionModel().getSelectedItem().trim(),
					genderNewFre.getSelectionModel().getSelectedItem().trim());
			frecuans newfrecuansAddFre = new frecuans(Integer.parseInt(bYearNewFre.getText().trim()),
					Integer.parseInt(bFrecNewFre.getText().trim()));

			HashNode dataNode = hashTabel.findNode(newBabyFre);

			if (dataNode == null) {
				resultForAddFre.setText("Sorry The Baby in The Selected Gender is not Found");
			} else {

				boolean chick = true;
				for (int i = 0; i < dataNode.getFrec().getSize(); i++) {
					frecuans heapp[] = dataNode.getFrec().getHeapTablee();
					resultForAddFre.setText("New Year And Frecunce add sucsesfuly");
					if (heapp[i] != null && (heapp[i].getYear() == Integer.parseInt(bYearNewFre.getText().trim()))) {
						chick = false;
						break;
					} else {
						chick = true;
					}

				}
				if (chick) {
					dataNode.getFrec().insert(newfrecuansAddFre);
					hashTabel.printHashTable();
				} else {
					resultForAddFre.setText("Sorry, but this year already exists. You can go to the edit box to edit it");
				}

			}
		});

		// Update Frecuance
		updateFrec.setOnAction(e -> {
			for (int i = 0; i < hashTabel.getTableSize(); i++) {
				HashNode x[] = hashTabel.getTable();
				if (x[i] != null) {
					bNameUpdateFre.getItems().add(x[i].getData().getName());
				}
			}
			bp6.setBottom(menub);
			wind.setScene(scene6);
		});

		updateFre.setOnAction(e -> {
			resultForUpdate.setText("");
			Babys updateBabyFre = new Babys(bNameUpdateFre.getSelectionModel().getSelectedItem().trim(),
					genderUpdateFre.getSelectionModel().getSelectedItem().trim());
			HashNode dataNode = hashTabel.findNode(updateBabyFre);

			if (dataNode == null) {
				resultForUpdate.setText("Sorry The Baby in\n The Selected Gender is not Found");
			} else {
				
				if (!(bYearUpdateFreOld.getText().equals("") || bYearUpdateFreNew.getText().equals(""))) {
					boolean chick = true;

					for (int i = 0; i < dataNode.getFrec().getSize(); i++) {
						frecuans heapp[] = dataNode.getFrec().getHeapTablee();
						if (heapp[i] != null && (heapp[i].getYear() == Integer.parseInt(bYearUpdateFreOld.getText().trim()))) {
							heapp[i].setYear(Integer.parseInt(bYearUpdateFreNew.getText().trim()));
							if (bFrecUpdateFreNew.getText().equals("")) {
								Integer u = heapp[i].getFrec();
								bFrecUpdateFreOld.setText(u.toString());
								hashTabel.printHashTable();
								break;
							} else {
								if (heapp[i] != null && (heapp[i].getFrec() == Integer.parseInt(bFrecUpdateFreOld.getText().trim()))) {
									heapp[i].setFrec(Integer.parseInt(bFrecUpdateFreNew.getText().trim()));
									System.out.println(heapp[i].getFrec());
									Integer u = heapp[i].getFrec();
									bFrecUpdateFreOld.setText(u.toString());
									resultForUpdate.setText("Frecunce Update Sucsesful");
									hashTabel.printHashTable();
									chick = true;
									break;
								} 
							}

						}
						else
							chick = false;
					}

					if (chick != true) {
						resultForUpdate.setText("Sorry, but this year does not exist. \n If you want to add it, please go to the addition section");
					}
				}
				//Update Only Frecunsy
				else if (!(bYearUpdateFreOld.getText().equals("")) && bYearUpdateFreNew.getText().equals("")) {
					boolean chick = true;
					for (int i = 0; i < dataNode.getFrec().getSize(); i++) {
						frecuans heapp[] = dataNode.getFrec().getHeapTablee();
						if (heapp[i] != null
								&& (heapp[i].getYear() == Integer.parseInt(bYearUpdateFreOld.getText().trim()))) {
							if (bFrecUpdateFreNew.getText().equals("")) {
								Integer u = heapp[i].getFrec();
								bFrecUpdateFreOld.setText(u.toString());
								hashTabel.printHashTable();
								chick = true;
								break;
							} else if (heapp[i] != null && (heapp[i].getFrec() == Integer.parseInt(bFrecUpdateFreOld.getText().trim()))){
//								int x =dataNode.getFrec().getSize();
//								for(int l =0 ;l<x;l++) {
//									if()
//								}
									heapp[i].setFrec(Integer.parseInt(bFrecUpdateFreNew.getText().trim()));
									System.out.println(heapp[i].getFrec());
									Integer u = heapp[i].getFrec();
									bFrecUpdateFreOld.setText(u.toString());
									hashTabel.printHashTable();
									chick = true;
									
									
							}
							else {
								chick = false;
							}
						} 
						else {
							chick = false;
						}
					}

					if (chick != true) {
						resultForUpdate.setText("Sorry, but this year does not exist. \n If you want to add it, please go to the addition section");
					}
				}
				
			

			}
		});
		
		
		// Max Frequency Action
		maxFrequency.setOnAction(e -> {
			bp7.setBottom(menub);
			wind.setScene(scene7);
		});
		maxFre.setOnAction(e -> {
			if (maxNodeee() != null)
				resultForMax.setText(maxNodeee().toString());
			else
				resultForMax.setText("An Error here");
		});
		dataTabele.setOnAction(e ->{
			wind.setScene(scene8);
		});

		// Exit
		exit.setOnAction(e -> { // Exit Button
			wind.close();
		});
		
		Show.setOnAction(e ->{
			textArea.setText(hashTabel.printHashString());
			wind.setScene(scene8);
		});
		
		wind.setScene(scene0);
		wind.setTitle("Baby Frequency");
		wind.show();

	}

	public HashNode maxNodeee() {
		int max = 0;
		
		HashNode maxNodee = null;
		for (int i = 0; i < hashTabel.getTableSize(); i++) {
			int sum = 0;
			HashNode x[] = hashTabel.getTable();
			if (x[i] != null) {
				frecuans heapp[] = x[i].getFrec().getHeapTablee();
				for (int j = 0; j < x[i].getFrec().getSize(); j++) {
					if (heapp[j] != null) {
						int u = heapp[j].getFrec();
						sum += u;
					}
				}
				if (sum > max) {
					max = sum;
					maxNodee = x[i];
				}
			}
			if (i == (hashTabel.getTableSize() - 1)) {
				return maxNodee;
			}
		}
		return maxNodee;
	}
}
