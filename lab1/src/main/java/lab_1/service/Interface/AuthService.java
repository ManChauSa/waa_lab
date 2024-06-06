package lab_1.service.Interface;

import lab_1.entity.dto.request.LoginRequest;
import lab_1.entity.dto.request.RefreshTokenRequest;
import lab_1.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
