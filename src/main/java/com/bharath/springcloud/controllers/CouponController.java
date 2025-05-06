package com.bharath.springcloud.controllers;

import com.bharath.springcloud.model.Coupon;
import com.bharath.springcloud.repos.CouponRepo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponController {
    private final CouponRepo couponRepo;

    public CouponController(CouponRepo couponRepo) {
        this.couponRepo = couponRepo;
    }

    @PostMapping("/coupons")
    public Coupon create(@RequestBody Coupon coupon){
        return couponRepo.save(coupon);
    }

    @GetMapping(value = "/coupon/{code}")
    public Coupon getCoupon(@PathVariable("code") String code){
        return couponRepo.findByCode(code);
    }
}
