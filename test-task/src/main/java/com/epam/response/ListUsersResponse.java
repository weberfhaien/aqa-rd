package com.epam.response;

import com.epam.response.dto.SupportDto;
import com.epam.response.dto.UserDto;

import java.util.List;

public class ListUsersResponse {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
    private List<UserDto> data;
    private SupportDto support;

    public ListUsersResponse() {
    }

    public ListUsersResponse(int page, int per_page, int total, int total_pages, List<UserDto> data, SupportDto support) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
    }

    public int getPage() {
        return page;
    }

    public int getPer_page() {
        return per_page;
    }

    public int getTotal() {
        return total;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public List<UserDto> getData() {
        return data;
    }

    public SupportDto getSupport() {
        return support;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public void setData(List<UserDto> data) {
        this.data = data;
    }

    public void setSupport(SupportDto support) {
        this.support = support;
    }
}
