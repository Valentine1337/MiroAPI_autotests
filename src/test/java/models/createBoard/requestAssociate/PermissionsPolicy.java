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
public class PermissionsPolicy {
    private String
            collaborationToolsStartAccess,
            copyAccess,
            sharingAccess;

    public void setOpenPermissionsPolicy() {
        setCollaborationToolsStartAccess("all_editors");
        setCopyAccess("anyone");
        setSharingAccess("team_members_with_editing_rights");
    }

    public void setPrivatePermissionsPolicy() {
        setCollaborationToolsStartAccess("board_owners_and_coowners");
        setCopyAccess("board_owner");
        setSharingAccess("owner_and_coowners");
    }
}
