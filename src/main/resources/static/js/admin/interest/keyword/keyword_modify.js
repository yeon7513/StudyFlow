// 키워드 수정 요청 핸들러
const handleSubmitModifiedKeywordInfo = async (targetNo, renderBox) => {
  const form = document.querySelector(".keyword-modify");
  const formData = new FormData(form);

  try {
    const response = await fetch(`/admin/management/interest/keyword/update/${targetNo}/info`, {
      method: "POST",
      body: formData,
    });

    const result = await response.json();

    return {
      ...result,
      newKeywordName: form.name.value,
    }
  } catch (error) {
    console.error("Error:", error);

    return {
      success: false,
      message: "서버와 연결할 수 없습니다. 네트워크 상태를 확인해주세요.",
    };
  }
}

export {handleSubmitModifiedKeywordInfo};
