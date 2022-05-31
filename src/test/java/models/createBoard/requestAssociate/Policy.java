package models.createBoard.requestAssociate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Policy {
    private PermissionsPolicy permissionsPolicy = new PermissionsPolicy();
    private SharingPolicy sharingPolicy = new SharingPolicy();

    public Policy (String typeOfPolicy) {
        if (typeOfPolicy.equals("open")) {
            permissionsPolicy.setOpenPermissionsPolicy();
            sharingPolicy.setOpenSharingPolicy();
        } else if (typeOfPolicy.equals("private")) {
            permissionsPolicy.setPrivatePermissionsPolicy();
            sharingPolicy.setPrivateSharingPolicy();
        }
    }
}
