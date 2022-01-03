package review;

import java.io.File;
import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class WriteReviewImpl implements IWriteReview{
	private IReviewDAO iReviewDAO;
	
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
	public String attachPicture() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
				new ExtensionFilter("이미지 파일", "*.img", "*.png"),
				new ExtensionFilter("All files", "*.*")
				);
		
		File file = fileChooser.showOpenDialog(null);
		
//		내가 지정
//		C:\Users\rnjsd\git\Travel\Travel\src\img\~~
//		C:/Users/rnjsd/git/Travel/Travel/src/img/~~
//		return getFilePath(file);
		return "";
	}
//	첨부할 사진의 저장 경로반환
//	private String getFilePath(File file) {
//		String filePath = "";
//		
//		try {
////			파일의 경로를 얻어옴
//			filePath = file.getPath();
////			만약 file이 Null인 경우 catch 부분 실행
//		}catch(NullPointerException e) {
////			Mac에 다운로드 폴더가 어떻게 처리 될지 몰라 임시 폴더로 변경
////			filePath = getDownloadDir() + "tmp.txt";
//			filePath = getTmpDir() + "tmp.txt";
//		}
//		return filePath;
//	}
}
