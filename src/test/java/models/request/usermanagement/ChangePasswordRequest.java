package models.request.usermanagement;


public class ChangePasswordRequest {
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;

    ChangePasswordRequest(String currentPassword, String newPassword, String confirmPassword) {
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public static ChangePasswordRequestBuilder builder() {
        return new ChangePasswordRequestBuilder();
    }

    public String getCurrentPassword() {
        return this.currentPassword;
    }

    public String getNewPassword() {
        return this.newPassword;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ChangePasswordRequest)) return false;
        final ChangePasswordRequest other = (ChangePasswordRequest) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$currentPassword = this.getCurrentPassword();
        final Object other$currentPassword = other.getCurrentPassword();
        if (this$currentPassword == null ? other$currentPassword != null : !this$currentPassword.equals(other$currentPassword))
            return false;
        final Object this$newPassword = this.getNewPassword();
        final Object other$newPassword = other.getNewPassword();
        if (this$newPassword == null ? other$newPassword != null : !this$newPassword.equals(other$newPassword))
            return false;
        final Object this$confirmPassword = this.getConfirmPassword();
        final Object other$confirmPassword = other.getConfirmPassword();
        if (this$confirmPassword == null ? other$confirmPassword != null : !this$confirmPassword.equals(other$confirmPassword))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ChangePasswordRequest;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $currentPassword = this.getCurrentPassword();
        result = result * PRIME + ($currentPassword == null ? 43 : $currentPassword.hashCode());
        final Object $newPassword = this.getNewPassword();
        result = result * PRIME + ($newPassword == null ? 43 : $newPassword.hashCode());
        final Object $confirmPassword = this.getConfirmPassword();
        result = result * PRIME + ($confirmPassword == null ? 43 : $confirmPassword.hashCode());
        return result;
    }

    public String toString() {
        return "ChangePasswordRequest(currentPassword=" + this.getCurrentPassword() + ", newPassword=" + this.getNewPassword() + ", confirmPassword=" + this.getConfirmPassword() + ")";
    }

    public static class ChangePasswordRequestBuilder {
        private String currentPassword;
        private String newPassword;
        private String confirmPassword;

        ChangePasswordRequestBuilder() {
        }

        public ChangePasswordRequestBuilder currentPassword(String currentPassword) {
            this.currentPassword = currentPassword;
            return this;
        }

        public ChangePasswordRequestBuilder newPassword(String newPassword) {
            this.newPassword = newPassword;
            return this;
        }

        public ChangePasswordRequestBuilder confirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public ChangePasswordRequest build() {
            return new ChangePasswordRequest(this.currentPassword, this.newPassword, this.confirmPassword);
        }

        public String toString() {
            return "ChangePasswordRequest.ChangePasswordRequestBuilder(currentPassword=" + this.currentPassword + ", newPassword=" + this.newPassword + ", confirmPassword=" + this.confirmPassword + ")";
        }
    }
}
