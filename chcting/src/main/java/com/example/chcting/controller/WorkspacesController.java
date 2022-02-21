package com.example.chcting.controller;

import com.example.chcting.dto.WorkspacesRequestDto;
import com.example.chcting.dto.WorkspacesResponseDto;
import com.example.chcting.model.User;
import com.example.chcting.model.Workspaces;
import com.example.chcting.repository.UserRepository;
import com.example.chcting.repository.WorkspacesRepository;
import com.example.chcting.security.UserDetailsImpl;
import com.example.chcting.service.WorkspacesService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class WorkspacesController {

    private final WorkspacesRepository workspacesRepository;
    private final WorkspacesService workspacesService;
    private final UserRepository userRepository;

    //워크스페이스 생성
    @PostMapping("/api/workspaces")
    public Workspaces ceateWs(
            @RequestBody WorkspacesRequestDto workspacesRequestDto,
            @AuthenticationPrincipal UserDetailsImpl userDetails
    ) {
        User user = userDetails.getUser();
        return workspacesService.createWs(workspacesRequestDto, user);
    }

    // 워크스페이스 조회
    @GetMapping("/api/workspaces/")
    public List<WorkspacesResponseDto> getWorkspace() {

        List<Workspaces> workspacesList = workspacesRepository.findAllByOrderByCreatedAtDesc();

        List<WorkspacesResponseDto> workspacesResponseDtos = new ArrayList<>();

        for (Workspaces workspace : workspacesList) {
            WorkspacesResponseDto workspacesResponseDto = new WorkspacesResponseDto(
                    workspace.getWorkId(),
                    workspace.getWorkName(),
                    workspace.getUser().getUsername(),
                    workspace.getUser().getNickname()
            );

            workspacesResponseDtos.add(workspacesResponseDto);
        }
        return workspacesResponseDtos;
    }

    //워크스페이스 삭제
    @DeleteMapping("/api/workspaces/{workId}")
    public Long deleteWs(@PathVariable Long workId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        workspacesService.deleteWs(workId, userDetails);
        return workId;
    }

}
