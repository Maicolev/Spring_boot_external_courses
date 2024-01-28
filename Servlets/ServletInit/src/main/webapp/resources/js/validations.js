function validateForm (){
    let v_form = document.form1;

    let v_user = v_form.user.value;
    let v_password = v_form.password.value;
    let v_occupation = v_form.occupation.value;
    //let v_comments = v_form.comments.value;

    const v_list_technologies = v_form.technologies;
    const v_list_genders = v_form.radioGender;
    //const v_fMusic = v_form.favoriteMusic;

    let technologiesSelected = false;
    let gendersSelected = false;

    if (v_user === ''){
        alert ('Please complete user field');
        return false;
    }
    if (v_password === ''){
        alert ('Please complete password field');
        return false;
    }
    if (v_occupation === 'none' || v_occupation === ''){
        alert ('Please complete occupation field');
        return false;
    }
    for (const technologie of v_list_technologies) {
        if (technologie.checked){
            technologiesSelected = true;
        }
    }
    if(technologiesSelected == false){
        alert ('Please complete techonologies field');
        return false;
    }
    for (const gender of v_list_genders) {
        if (gender.checked){
            gendersSelected = true;
        }
    }
    if(gendersSelected == false){
        alert ('Please complete gender field');
        return false;
    }
}