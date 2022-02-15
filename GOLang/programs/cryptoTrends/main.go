package main

import (
	"fmt"
	"io/ioutil"
	"net/http"
	"strconv"
	"time"
)

const BASE_URL = "https://api.coincap.io/v2/"
const COIN = "bitcoin"
const TOKEN = ""

func main() {
	t := time.Now()
	t = t.AddDate(0, -1, 0)
	fmt.Println(t)
	t2 := t.AddDate(-1, -1, 0)
	fmt.Println(t2)
	var headers = make(map[string]string)
	headers["Authorization"] = "Bearer " + TOKEN
	url := BASE_URL + "assets/" + COIN + "/history?start=" + strconv.FormatInt(t2.UTC().Unix(), 10) + "&end=" + strconv.FormatInt(t.UTC().Unix(), 10)
	// url := BASE_URL + "assets/" + COIN + "/history?interval=d1"

	method := "GET"
	fmt.Println(url)
	client := &http.Client{}
	req, err := http.NewRequest(method, url, nil)

	if err != nil {
		fmt.Println(err)
		return
	}
	for key := range headers {
		req.Header.Add(key, headers[key])
	}

	res, err := client.Do(req)
	if err != nil {
		fmt.Println(err)
		return
	}
	defer res.Body.Close()

	body, err := ioutil.ReadAll(res.Body)
	if err != nil {
		fmt.Println(err)
		return
	}
	fmt.Println(string(body))
}
