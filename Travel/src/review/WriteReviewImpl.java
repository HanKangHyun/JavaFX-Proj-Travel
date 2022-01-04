package review;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import db.dto.ReviewDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class WriteReviewImpl implements IWriteReview{
	private IReviewDAO iReviewDAO;
	private String picPath = "";
	
	public WriteReviewImpl() {
		iReviewDAO = new ReviewDAOImpl();
	}

//	리뷰작성 취소
	@Override
	public void cancelReview(Stage stage, Parent form) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Review.fxml"));
			form = (Parent) loader.load();
			Scene sc = new Scene(form);
			
			stage.setTitle("리뷰");
			stage.setScene(sc);
			stage.show();
			
			ReviewCtrl ctrler = loader.getController();
			ctrler.setForm(stage, form);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	사진첨부
	@Override
	public void attachPicture(TextArea txtArea) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("이미지 파일", "*.img", "*.png", "*.JPG"),
				new ExtensionFilter("All files", "*.*")
				);
		
//		File file = fileChooser.showOpenDialog(null);
		List<File> file = fileChooser.showOpenMultipleDialog(null);
		
		String Path = getFilePath(file);
		if(!Path.equals("")) {
			picPath += Path + "\n";
			txtArea.setText(picPath);
		}
	}

//	첨부 사진의 경로반환
	private String getFilePath(List<File> file) {
		String filePath="";
		
		try {
			for(int i=0; i<file.size(); i++) {
				if(i == file.size()-1)
					filePath += file.get(i).getPath();
				else
					filePath += file.get(i).getPath() + "\n";
			}
			
		}catch(NullPointerException e) {
			filePath = "";
		}
		return filePath;
	}


//	리뷰 등록
	@Override
	public void registReview(TextField reviewTitle, TextField reviewContent, 
			TextField reviewSummary, TextArea txtArea) {
		String title = reviewTitle.getText();
		String content = reviewContent.getText();
		String summary = reviewSummary.getText();
//		파일여러개면 리스트로 하나씩해야할듯?
		String imgFile = txtArea.getText();
		imgFile = imgFile.substring(0, imgFile.length()-1);
		
		System.out.println(title);
		System.out.println(content);
		System.out.println(summary);
		System.out.println(imgFile);
		
		imgFile = storeImg(imgFile);

		ReviewDTO dto = new ReviewDTO(title, content, summary, imgFile);
		iReviewDAO.insertReview(dto);
		
	}
	
//  이미지 저장
	private String storeImg(String imgFile) {
		String Path = "C:/Users/rnjsd/git/Travel/Travel/src/img/";
		String imgName = getImgName();
		String imgPath = Path + imgName;
		
		File oriFile = new File(imgFile);
		File copyFile = new File(imgPath);
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(oriFile);
			fos = new FileOutputStream(copyFile);
			
			int fileByte = 0;
			while((fileByte = fis.read()) != -1) {
				fos.write(fileByte);
			}
			
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return imgPath;
	}

//	첨부할 사진의 저장 경로반환
	private String getImgName() {
		String imgName = "img_";
		
		LocalDate nowDate = LocalDate.now();
		DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy_MM_dd_");
		String formatedNow = nowDate.format(formatterDate);

		LocalTime nowTime = LocalTime.now();
		DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HHmmss");
		String formatedTime = nowTime.format(formatterTime);

//		System.out.println(formatedNow + formatedTime);	
		imgName += formatedNow + formatedTime + ".JPG";
		
		return imgName;
	}

	@Override
	public void pageBack(Stage stage, Parent form) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Review.fxml"));
			form = (Parent) loader.load();
			Scene sc = new Scene(form);
			
			stage.setTitle("리뷰");
			stage.setScene(sc);
			stage.show();
			
			ReviewCtrl ctrler = loader.getController();
			ctrler.setForm(stage, form);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
