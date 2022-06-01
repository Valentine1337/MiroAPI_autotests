package models.createBoard.requestAssociate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SharingPolicy {
    private String access;
    private String inviteToAccountAndBoardLinkAccess;
    private String organizationAccess;
    private String teamAccess;

    public void setOpenSharingPolicy() {
        setAccess("edit");
        setInviteToAccountAndBoardLinkAccess("editor");
        setOrganizationAccess("private");
        setTeamAccess("edit");
    }

    public void setPrivateSharingPolicy() {
        setAccess("private");
        setInviteToAccountAndBoardLinkAccess("no_access");
        setOrganizationAccess("private");
        setTeamAccess("private");
    }
}
