package nextstep.subway.ui;

import nextstep.subway.applicaion.PathService;
import nextstep.subway.applicaion.dto.PathRequest;
import nextstep.subway.applicaion.dto.PathResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathController {

    private PathService pathService;

    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    @GetMapping("paths")
    public ResponseEntity<PathResponse> findPath(@ModelAttribute PathRequest pathrequest) {
        final PathResponse path = pathService.findPath(pathrequest.getSource(), pathrequest.getTarget());
        return ResponseEntity.ok(path);
    }
}