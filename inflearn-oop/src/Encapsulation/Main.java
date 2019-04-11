package Encapsulation;

/**
 * @author choijaeyong on 11/04/2019.
 * @project inflearn-oop
 * @description
 */
public class Main {

  enum AuthResult {
    NO_MATCH, NO_EMAIL_VERIFIED, SUCCESS


  }

  private class Member {
    String id;
    String pw;
    int verificationEmailStatus;
    public Member(String id) {
      this.id = id;
    }
    public void setVerificationEmailStatus(int v) {
      this.verificationEmailStatus = v;
    }
    public void setPassword(String pw) {
      this.pw = pw;
    }
    public String getPassword() {
      return this.pw;
    }
    public String getId() {
      return this.id;
    }
    public int getVerificationEmailStatus() {
      return verificationEmailStatus;
    }

    public boolean isEmailVerified() {
      return verificationEmailStatus == 2;
    }

    public void verifyEmail() {
      if(isEmailVerified())
        throw new AlreadyVerifiedException();
      else
        this.verificationEmailStatus = 2;
    }


  }

  private class PasswordEncoder {
    public boolean isPasswordValid(String memberPw, String pw, String id) {
      return true;
    }
  }


  public Member findOne(String id) {
    return new Member(id);
  }

  public Member findByToken(String token) {
    return new Member("token");
  }

  public AuthResult authenticate(String id, String pw) {
    PasswordEncoder passwordEncoder = new PasswordEncoder();
    Member mem = findOne(id);
    if(mem == null) return AuthResult.NO_MATCH;

    // Tell, Don't ask! 캡슐화대상.
//    if(mem.getVerificationEmailStatus() != 2) {
//      return AuthResult.NO_EMAIL_VERIFIED;
//    }

    if(mem.isEmailVerified()) {
      return AuthResult.NO_EMAIL_VERIFIED;
    }

    if(passwordEncoder.isPasswordValid(mem.getPassword(),pw,mem.getId())) {
      return AuthResult.SUCCESS;
    }

    return AuthResult.NO_MATCH;

  }


  public void verifyEmail(String token) {
    Member mem = findByToken(token);
    if(mem==null) throw new BadTokenException();

//    if(mem.getVerificationEmailStatus() ==2) {
//      throw new AlreadyVerifiedException();
//    } else {
//      mem.setVerificationEmailStatus(2);
//    }

    mem.verifyEmail();

  }

}

class BadTokenException extends RuntimeException {

}

class AlreadyVerifiedException extends RuntimeException {

}