package io.hhplus.tdd.point;


import io.hhplus.tdd.domain.Member;
import io.hhplus.tdd.domain.Point;
import io.hhplus.tdd.service.PointService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/point")
public class PointController {

    private static final Logger log = LoggerFactory.getLogger(PointController.class);

    PointService pointService;

    public PointController(PointService pointService) {
        this.pointService = pointService;
    }

    /**
     * TODO - 특정 유저의 포인트를 조회하는 기능을 작성해주세요.
     */
//    @GetMapping("{id}")
//    public UserPoint point(
//            @PathVariable long id
//    ) {
//
//        return new UserPoint(0, 0, 0);
//    }
    @GetMapping("{id}")
    public String point(@PathVariable long id, Model model) {

        Optional<Point> point = pointService.getUserPoint(id);
        model.addAttribute("point", point);

        return "/point/select";
    }

    /**
     * TODO - 특정 유저의 포인트 충전/이용 내역을 조회하는 기능을 작성해주세요.
     */
//    @GetMapping("{id}/histories")
//    public List<PointHistory> history(
//            @PathVariable long id
//    ) {
//        return List.of();
//    }
    @GetMapping("{id}/histories")
    public String history(
            @PathVariable long id,
            Model model,
            Member meber
    ) {
        Optional<Point> history = pointService.getUserPointHistory(meber);
        model.addAttribute("point", history);

        return "/point/history";
    }

    /**
     * TODO - 특정 유저의 포인트를 충전하는 기능을 작성해주세요.
     */
//    @PatchMapping("{id}/charge")
//    public UserPoint charge(
//            @PathVariable long id,
//            @RequestBody long amount
//    ) {
//        return new UserPoint(0, 0, 0);
//    }
    @PatchMapping("{id}/charge")
    public Point charge (@PathVariable long id
                         , Point point
                    ){
        Point charge = pointService.save(point);

        return charge;
    }
    /**
     * TODO - 특정 유저의 포인트를 사용하는 기능을 작성해주세요.
     */
//    @PatchMapping("{id}/use")
//    public UserPoint use(
//            @PathVariable long id,
//            @RequestBody long amount
//    ) {
//        return new UserPoint(0, 0, 0);
//    }
    @PatchMapping("{id}/use")
    public Point use(
            @PathVariable long id,
            @RequestBody long amount,
            Point point
    ) {
        Point use = pointService.save(point);

        return use;
    }


}
