function addRecord() {

            window.location.href = "Member?act=insert";
        }

        function check() {
            if (!form.x.value) {
                alert("Please fill the keyword to search..");
                return (false);
            }
            return (true);
        }
		
		