/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow.domain.role;

import io.vizend.accent.domain.role.AbstractDramaRoles;
import io.vizend.accent.domain.role.GroupRoles;

import java.util.List;

public class StudyflowRoles extends AbstractDramaRoles {
    //
    public static final String DRAMA_NAME = "studyflow";
    public static final String GROUP_ROLE_ADMIN = "admin";
    public static final String GROUP_ROLE_ADMIN_ABBREVIATION = "adm";
    public static final String ROLE_ADMIN_MANAGER = "admin.manager";
    public static final String GROUP_ROLE_BUSINESS = "business";
    public static final String GROUP_ROLE_BUSINESS_ABBREVIATION = "biz";
    public static final String ROLE_BUSINESS_MANAGER = "business.manager";
    public static final String ROLE_BUSINESS_MEMBER = "business.member";

    public StudyflowRoles(String dramaName) {
        //
        super(dramaName);
    }

    private void initialize() {
        //
        this.addGroupRoles(GroupRoles.of(
                GROUP_ROLE_ADMIN,
                GROUP_ROLE_ADMIN_ABBREVIATION,
                List.of(ROLE_ADMIN_MANAGER)));
        this.addGroupRoles(GroupRoles.of(
                GROUP_ROLE_BUSINESS,
                GROUP_ROLE_BUSINESS_ABBREVIATION,
                List.of(ROLE_BUSINESS_MANAGER, ROLE_BUSINESS_MEMBER)));
    }

    public static void main(String[] args) {
        //
        String dramaName = DRAMA_NAME;
        StudyflowRoles dramaRoles = new StudyflowRoles(dramaName);
        dramaRoles.initialize();

        System.out.println(dramaRoles.getDramaGroupRoles().toPrettyJson());
        System.out.println(dramaRoles.toIdentifierString());
    }
}
