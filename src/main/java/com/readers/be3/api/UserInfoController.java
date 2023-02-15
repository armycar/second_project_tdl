package com.readers.be3.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.readers.be3.service.UserInfoService;
import com.readers.be3.vo.mypage.ResponseUserInfoVO;
import com.readers.be3.vo.mypage.UserImageVO;
import com.readers.be3.vo.mypage.UserInfoVO;
import com.readers.be3.vo.mypage.UserLoginVO;
import com.readers.be3.vo.mypage.UserNameVO;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;

@Tag(name = "회원 관리", description="회원정보 CRUD API")
@RestController
@RequestMapping("/api/user")
public class UserInfoController {
    @Value("${file.image.user}") String user_img_path;
    @Autowired UserInfoService uService;

    @Operation(summary = "회원 가입", description = "회원정보를 추가합니다.")
    @PutMapping("/join") //회원가입
    public ResponseEntity<Object> memberJoin(@RequestBody UserInfoVO data) {
      Map<String, Object> resultMap = uService.addUser(data);
      return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
    }
    @Operation(summary = "로그인", description = "로그인")
    @PostMapping("/login") //로그인
    public ResponseEntity<Object> memberLogin(@RequestBody UserLoginVO data) {
      Map<String, Object> resultMap = uService.loginUser(data);
      return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
    }
    @Operation(summary = "회원 탈퇴", description = "회원정보 번호(uiSeq)를 통해 회원정보를 삭제합니다")
    @DeleteMapping("/delete") //회원탈퇴
    public ResponseEntity<Object> memberDelete(@RequestParam Long uiSeq) throws Exception{
    Map <String ,Object> resultMap = uService.deleteUser(uiSeq);
    return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
  }
  @Operation(summary = "회원 정보 수정", description = "회원정보 번호(uiSeq)를 통해 회원정보(닉네임)를 수정합니다.")
    @PatchMapping("/update/name") //회원정보수정
    public ResponseEntity<Object> memberNameUpdate(@RequestParam Long uiSeq, @RequestBody UserNameVO data) throws Exception{
    Map <String ,Object> resultMap = uService.updateUserName(uiSeq, data);
    return new ResponseEntity<Object>(resultMap, (HttpStatus)resultMap.get("code"));
  }
  @Operation(summary = "회원 사진추가", description = "회원정보 번호(uiSeq)를 통해 회원사진을 추가합니다.")
    @PutMapping(value = "/update/photo", consumes= MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateUserPhoto(
        @Parameter(description = "formdata로 사진 데이터를 입력합니다")
        @ModelAttribute UserImageVO data
    ) {
        return new ResponseEntity<>(uService.updateUserPhoto(data), HttpStatus.OK);
    }

  @Operation(summary = "회원 정보", description = "회원정보 번호(uiSeq)를 통해 회원의 정보를 조회합니다.")
    @GetMapping("/info") //회원정보 조회
    public ResponseEntity<ResponseUserInfoVO> getMyRank(@RequestParam Long uiSeq){
      return new ResponseEntity<>(uService.getUserInfo(uiSeq),HttpStatus.OK);
    }  
}
